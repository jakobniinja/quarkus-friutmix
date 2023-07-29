package org.acme.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Fruit;
import org.acme.service.FruitService;

import java.util.List;

@Path("fruits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class FruitResource {

    @Inject
    FruitService fruitService;

    @GET
    public List<Fruit> getAll() {
        return fruitService.list();
    }

    @POST
    public List<Fruit> add(Fruit fruit) {
        fruitService.add(fruit);

        return getAll();
    }

    @DELETE
    @Path("{id}")
    public List<Fruit> remove(@PathParam(value = "id") String id) {
        fruitService.delete(id);

        return getAll();
    }

    @DELETE
    public List<Fruit> removeAll() {
        fruitService.deleteAll();

        return getAll();
    }
}
