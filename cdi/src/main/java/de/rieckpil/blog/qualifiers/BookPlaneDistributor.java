package de.rieckpil.blog.qualifiers;

@PlaneDistributor
public class BookPlaneDistributor implements BookDistributor {

  @Override
  public void distributeBook(String bookName) {
    System.out.println("Distributing book by plane");
  }
}
