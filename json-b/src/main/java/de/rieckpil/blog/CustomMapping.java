package de.rieckpil.blog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApplicationScoped
public class CustomMapping {

    private Book book = new Book("Java 11", LocalDate.now(), 1, false, "Duke", new BigDecimal(33.333));

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        JsonbConfig config = new JsonbConfig()
                .withAdapters(new BookAdapter());

        Jsonb jsonb = JsonbBuilder.create(config);

        String jsonString = jsonb.toJson(book);
        System.out.println(jsonString);

        Book serializedBook = jsonb.fromJson(jsonString, Book.class);
        System.out.println(serializedBook);
    }
}
