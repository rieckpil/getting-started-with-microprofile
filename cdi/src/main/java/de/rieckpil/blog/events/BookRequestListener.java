package de.rieckpil.blog.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.Default;

@ApplicationScoped
public class BookRequestListener {

  public void onBookRequest(@Observes(during = TransactionPhase.AFTER_SUCCESS) @Default BookRequest bookRequest) {
    System.out.println("New book request incoming: " + bookRequest.toString());
  }

  public void onBookForeignRequest(@Observes @ForeignBook BookRequest bookRequest) {
    System.out.println("New foreign book request incoming: " + bookRequest.toString());
  }

  public void onBookRequestAsync(@ObservesAsync BookRequest bookRequest) {
    System.out.println("New book request incoming async: " + bookRequest.toString());
  }
}
