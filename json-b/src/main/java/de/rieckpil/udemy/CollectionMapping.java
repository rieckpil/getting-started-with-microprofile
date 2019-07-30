package de.rieckpil.udemy;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CollectionMapping {

    private Book bookOne = new Book("Java 11", LocalDate.now(), 100, true, "Duke");
    private Book bookTwo = new Book("Java 15", LocalDate.of(2020, 01, 01), 110, false, "Duke");

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(bookOne);
        bookList.add(bookTwo);

        Jsonb jsonb = JsonbBuilder.create();

        String result = jsonb.toJson(bookList);
        System.out.println(result);

        List<Book> serializedBookList = jsonb
                .fromJson(result, new ArrayList<Book>() {
                }.getClass().getGenericSuperclass());
        serializedBookList.forEach(b -> System.out.println(b.toString()));
    }
}
