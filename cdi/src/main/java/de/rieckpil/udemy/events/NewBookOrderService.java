package de.rieckpil.blog.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;

@ApplicationScoped
public class NewBookOrderService {

    public void onBookForeignRequest(@Observes BookRequest bookRequest) {
        System.out.println("New book request incoming: " + bookRequest.toString());
    }


    public void onBookRequestAsync(@ObservesAsync BookRequest bookRequest) {
        System.out.println("New book request incoming async: " + bookRequest.toString());
    }
}
