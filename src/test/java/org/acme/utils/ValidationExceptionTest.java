package org.acme.utils;

import jakarta.ws.rs.core.Response;
import org.acme.controller.FruitResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

public class ValidationExceptionTest extends JerseyTest {


    @Override
    public ResourceConfig configure() {
        return new ResourceConfig()
                .register(FruitResource.class)
                .register(ValidationException.class);
    }

    @Test
    public void simpleGetFruits() {
        final Response response = target("/fruits")
                .request()
                .get();
    }
}
