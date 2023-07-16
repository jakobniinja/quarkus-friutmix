package org.acme.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.DeleteOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.Fruit;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lt;

@ApplicationScoped
public class FruitService {

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


    public void add(Fruit fruit) {

        String uuid = UUID.randomUUID().toString();
        Document document = new Document()
                .append("_id", uuid)
                .append("name", fruit.getName())
                .append("description", fruit.getDescription());

        getCollection().insertOne(document);
    }


    public void delete(String id) {

        Document document = new Document()
                .append("_id", id);
        getCollection().deleteOne(document);

    }

    public void deleteAll() {

        Bson query = gt("_id", "0");
        DeleteResult result = getCollection().deleteMany(query);
    }

    private MongoCollection getCollection() {
        return mongoClient.getDatabase("fruit").getCollection("fruit");
    }
}
