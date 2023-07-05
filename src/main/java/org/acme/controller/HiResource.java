package org.acme.controller;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Path("test")
public class HiResource {
    @GET
    public String hello() {
        return "hi from duke - " + LocalDateTime.now();
    }
}
