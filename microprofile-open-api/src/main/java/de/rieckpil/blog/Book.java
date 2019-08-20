package de.rieckpil.blog;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Book", description = "POJO that represents a book.")
public class Book {

    @Schema(required = true, example = "MicroProfile")
    private String title;

    @Schema(required = true, example = "Duke")
    private String author;

    @Schema(required = true, readOnly = true, example = "1")
    private Long id;

    public Book() {
    }

    public Book(String title, String author, Long id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
