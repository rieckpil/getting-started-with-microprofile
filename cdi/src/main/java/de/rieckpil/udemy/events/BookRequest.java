package de.rieckpil.udemy.events;

public class BookRequest {

    private String bookName;
    private Integer customerId;

    public BookRequest() {
    }

    public BookRequest(String bookName, Integer customerId) {
        this.bookName = bookName;
        this.customerId = customerId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "bookName='" + bookName + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
