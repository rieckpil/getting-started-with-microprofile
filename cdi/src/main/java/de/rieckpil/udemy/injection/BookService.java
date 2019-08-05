package de.rieckpil.udemy.injection;

import de.rieckpil.udemy.decorators.CustomerAccount;
import de.rieckpil.udemy.events.BookRequest;
import de.rieckpil.udemy.interceptors.BookPaymentProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class BookService {

    @Inject
    private Logger logger;

    @Inject
    private IsbnValidator isbnValidator;

    @Inject
    private BookPaymentProvider paymentProvider;

    @Inject
    private CustomerAccount customerAccount;

    @Inject
    private Event<BookRequest> bookRequestEvent;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        // paymentProvider.withdrawMoneyFromCustomer("Duke", 123);
        // paymentProvider.withdrawMoneyFromCustomer("Mike", 123);

        // this.storeBook("Java 11", "12345");
        // this.storeBook("Java 12", "1234");

        // this.bookRequestEvent.fire(new BookRequest("MicroProfile 3.0", 1));
        // this.bookRequestEvent.fireAsync(new BookRequest("MicroProfile 3.0", 1));

        // this.customerAccount.withdrawMoney(42.0);
        // this.customerAccount.withdrawMoney(142.0);
    }

    public void storeBook(String bookName, String isbn) {

        if (isbnValidator.validateIsbn(isbn)) {
            logger.info("Store book with name: " + bookName);
        }

    }

}
