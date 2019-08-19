package de.rieckpil.blog;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;

import java.io.File;

@Liveness
public class DiskSizeCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        File file = new File("/");
        long freeSpace = file.getFreeSpace() / 1024 / 1024;

        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.builder()
                .name("disk")
                .withData("remainingSpace", freeSpace);

        if (freeSpace < 1_000) {
            return responseBuilder
                    .down()
                    .build();
        }

        return responseBuilder
                .up()
                .build();
    }
}
