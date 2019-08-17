package de.rieckpil.blog;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import java.time.LocalDate;

public class BookAdapter implements JsonbAdapter<Book, JsonObject> {

    @Override
    public JsonObject adaptToJson(Book book) throws Exception {
        return Json.createObjectBuilder()
                .add("title", book.getTitle() + " - " + book.getAuthor())
                .add("creationDate", book.getCreationDate().toEpochDay())
                .add("pages", book.getPages())
                .build();
    }

    @Override
    public Book adaptFromJson(JsonObject jsonObject) throws Exception {
        Book book = new Book();
        book.setTitle(jsonObject.getString("title").split("-")[0].trim());
        book.setAuthor(jsonObject.getString("title").split("-")[1].trim());
        book.setPages(jsonObject.getInt("pages"));
        book.setPublished(false);
        book.setCreationDate(LocalDate.ofEpochDay(jsonObject.getInt("creationDate")));
        return book;
    }
}
