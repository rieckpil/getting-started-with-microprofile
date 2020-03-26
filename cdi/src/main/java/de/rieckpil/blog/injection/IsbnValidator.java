package de.rieckpil.blog.injection;

import javax.inject.Inject;
import java.util.logging.Logger;

public class IsbnValidator {

  @Inject
  private Logger logger;

  public boolean validateIsbn(String isbn) {
    if (isbn.replace("-", "").length() < 13) {
      logger.warning("ISBN validation failed for ISBN: " + isbn);
      return false;
    }
    return true;
  }
}
