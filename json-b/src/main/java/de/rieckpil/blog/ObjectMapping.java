package de.rieckpil.blog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApplicationScoped
public class ObjectMapping {

  public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

    Book book = new Book("Java 11", LocalDate.now(), 1, false, "Duke", new BigDecimal(44.444));

    Jsonb jsonb = JsonbBuilder.create();

    String resultJson = jsonb.toJson(book);
    System.out.println(resultJson);

    Book serializedBook = jsonb.fromJson(resultJson, Book.class);
    System.out.println(serializedBook.toString());
  }
}
