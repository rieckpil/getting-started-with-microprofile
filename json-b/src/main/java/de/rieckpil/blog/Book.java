package de.rieckpil.blog;

import javax.json.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;

// @JsonbNillable
public class Book {

    @JsonbProperty(nillable = true)
    private String title;

    @JsonbDateFormat("dd.MM.yyyy")
    private LocalDate creationDate;
    private long pages;

    @JsonbTransient
    private boolean isPublished;
    private String author;

    @JsonbNumberFormat("#0.00")
    private BigDecimal price;

    public Book() {
    }

    // @JsonbCreator
    public Book(@JsonbProperty("book-title") String title) {
        this.title = title;
    }

    public Book(String title, LocalDate creationDate, long pages, boolean isPublished, String author, BigDecimal price) {
        this.title = title;
        this.creationDate = creationDate;
        this.pages = pages;
        this.isPublished = isPublished;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", pages=" + pages +
                ", isPublished=" + isPublished +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
