package org.acme.controller;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class ReadyResource implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.down("Simple ready check");
    }
}
