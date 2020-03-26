package de.rieckpil.blog.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class BookRequestPublisher {

  @Inject
  private Event<BookRequest> bookRequestEvent;

  @Inject
  @ForeignBook
  private Event<BookRequest> foreignBookRequestEvent;

  public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

    this.bookRequestEvent.fire(new BookRequest("MicroProfile 3.0", 1));
    this.foreignBookRequestEvent.fire(new BookRequest("MicroProfile 3.0 (German)", 1));

    this.bookRequestEvent
      .fireAsync(new BookRequest("MicroProfile 3.0", 1))
      .handle((request, error) -> {
        if (error == null) {
          System.out.println("Successfully fired async event");
          return request;
        } else {
          System.out.println("Error occured during async event");
          return null;
        }
      })
      .thenAccept(r -> System.out.println(r));
  }

}
