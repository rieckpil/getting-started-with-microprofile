package de.rieckpil.udemy.injection;

public class IsbnValidator {

    public boolean validateIsbn(String isbn) {
        if(isbn.length() >= 5) {
            return false;
        }

        return true;
    }

}
