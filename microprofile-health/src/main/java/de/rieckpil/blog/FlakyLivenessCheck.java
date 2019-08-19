package de.rieckpil.blog;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;

import java.util.concurrent.ThreadLocalRandom;

@Liveness
public class FlakyLivenessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse
                .builder()
                .name("liveness");

        if (ThreadLocalRandom.current().nextBoolean()) {
            return responseBuilder.down().build();
        }

        return responseBuilder.up().build();
    }
}
