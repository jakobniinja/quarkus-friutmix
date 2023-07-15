package org.acme.controller;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.time.LocalDateTime;

@Path("test")
@Tag(name = "JAX-RS Ping Resource", description = "A Ping resource that returns a greeting")
public class HiResource {
    @GET
    public String hello() {
        return "hi from duke - " + LocalDateTime.now();
    }
}
