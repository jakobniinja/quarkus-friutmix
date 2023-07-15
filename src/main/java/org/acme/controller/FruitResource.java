package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Fruit;
import org.acme.service.FruitService;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("fruits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "JAX-RS Fruit Resource", description = "Crud operation available for a wide variety of fruits")
@APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Successfully retrieved"),
        @APIResponse(responseCode = "404", description = "Not found - The fruit was not found"),
        @APIResponse(responseCode = "400", description = "Bad request - a field was added/removed request"),
        @APIResponse(responseCode = "500", description = "Internal Server Error - Unaccepted behavior")
})
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
