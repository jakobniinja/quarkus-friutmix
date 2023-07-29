package org.acme.controller;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.metrics.MetricRegistry;

import java.time.LocalDateTime;

@Path("test")
@ApplicationScoped
public class HiResource {

    @Inject
    MetricRegistry metricRegistry;

    @GET
    public String hello() {
        metricRegistry.counter("greeting").inc();

        return "hi from duke - " + LocalDateTime.now();
    }
}
