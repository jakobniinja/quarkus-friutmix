package org.acme.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.acme.model.Fruit;
import org.acme.utils.Counter;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;

@ApplicationScoped
public class FruitService {

    private Counter counter = new Counter();

    @Inject
    MongoClient mongoClient;

    public List<Fruit> list() {
        List<Fruit> list = new ArrayList<>();

        try (MongoCursor<Document> cursor = getCollection().find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Fruit fruit = new Fruit();
                fruit.set_id(document.getString("_id"));
                fruit.setName(document.getString("name"));
                fruit.setDescription(document.getString("description"));
                list.add(fruit);
            }
        }
        return list;
    }


    public void add(@Valid Fruit fruit) {

        // perform empty name validation
        if (fruit.getName().isBlank()) {
            return;
        }


        // perform duplicate name validation


        counter.increment();

        Document document = new Document()
                .append("_id", String.valueOf(counter.getVal()))
                .append("name", fruit.getName())
                .append("description", fruit.getDescription());

        getCollection().insertOne(document);
    }


    public void delete(String id) {

        Bson query = eq("_id", id);
        DeleteResult result = getCollection().deleteOne(query);

    }

    public void deleteAll() {

        Bson query = gt("_id", "0");
        DeleteResult result = getCollection().deleteMany(query);
    }

    private MongoCollection getCollection() {
        return mongoClient.getDatabase("fruit").getCollection("fruit");
    }
}
