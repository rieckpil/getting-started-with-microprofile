package de.rieckpil.blog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CollectionMapping {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Java 11", LocalDate.now(), 100, true, "Duke", new BigDecimal(39.95)));
        bookList.add(new Book("Java 15", LocalDate.now().plus(365, ChronoUnit.DAYS), 110, false, "Duke", new BigDecimal(50.002)));

        Jsonb jsonb = JsonbBuilder.create();

        String result = jsonb.toJson(bookList);
        System.out.println(result);

        List<Book> serializedBookList = jsonb
                .fromJson(result, new ArrayList<Book>() {
                }.getClass().getGenericSuperclass());

        serializedBookList.forEach(b -> System.out.println(b.toString()));
    }
}
