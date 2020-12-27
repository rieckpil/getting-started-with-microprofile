package de.rieckpil.blog;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import java.util.concurrent.ThreadLocalRandom;

@Liveness
public class FlakyLivenessCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call() {

    return HealthCheckResponse
      .builder()
      .name("liveness")
      .status(ThreadLocalRandom.current().nextBoolean())
      .build();
  }
}
