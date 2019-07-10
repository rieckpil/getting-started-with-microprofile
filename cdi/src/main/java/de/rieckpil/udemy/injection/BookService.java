package de.rieckpil.udemy.injection;

import javax.inject.Inject;

public class BookService {

    private IsbnValidator isbnValidator;

    /**
     * @Inject public BookService(IsbnValidator isbnValidator) {
     * this.isbnValidator = isbnValidator;
     * }
     */

    public void storeBook(String bookName, String isbn) {

        if (isbnValidator.validateIsbn(isbn)) {
            System.out.println("Store book with name: " + bookName);
        }

    }

    @Inject
    public void setIsbnValidator(IsbnValidator isbnValidator) {
        this.isbnValidator = isbnValidator;
    }

}
