package de.rieckpil.udemy.qualifiers;

@PlaneDistributor
public class BookPlaneDistributor implements BookDistributor {

    @Override
    public void distributeBook(String bookName) {
        System.out.println("Distributing book by plane");
    }
}
