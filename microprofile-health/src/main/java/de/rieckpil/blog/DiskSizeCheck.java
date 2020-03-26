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
      .name("diskSizeCheck")
      .withData("remainingSpace", freeSpace);

    return responseBuilder
      .state(freeSpace > 100)
      .build();

  }
}
