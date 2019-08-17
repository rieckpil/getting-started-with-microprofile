package de.rieckpil.blog;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import java.io.File;

@Liveness
public class DiskCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        File file = new File("/");
        long freeSpace = file.getFreeSpace();

        if (freeSpace < 1_000_000_000) {
            return HealthCheckResponse.builder()
                    .name("disk")
                    .down()
                    .build();
        }

        return HealthCheckResponse.builder()
                .name("disk")
                .up()
                .withData("freeSpace", (freeSpace / 1024 / 1024))
                .build();
    }
}
