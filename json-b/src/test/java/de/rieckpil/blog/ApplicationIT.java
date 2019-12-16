package de.rieckpil.blog;

import org.junit.jupiter.api.Test;
import org.microshed.testing.jupiter.MicroShedTest;
import org.microshed.testing.testcontainers.ApplicationContainer;
import org.testcontainers.junit.jupiter.Container;

@MicroShedTest
public class ApplicationIT {

  @Container
  public static ApplicationContainer app = new ApplicationContainer()
    .withAppContextRoot("/")
    .withReadinessPath("/health/ready");

  @Test
  public void testApplicationStarts() {

  }
}
