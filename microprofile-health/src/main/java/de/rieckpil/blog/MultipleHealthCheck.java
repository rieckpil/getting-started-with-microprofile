package de.rieckpil.blog;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@Liveness
public class MultipleHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse
                .builder()
                .name("generalCheck")
                .withData("foo", "bar")
                .withData("uptime", 42)
                .withData("isReady", true)
                .up()
                .build();
    }
}
