package de.rieckpil.blog.injection;

import de.rieckpil.blog.decorators.CustomerAccount;
import de.rieckpil.blog.interceptors.BookPaymentProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
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

  public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
    this.paymentProvider.withdrawMoneyFromCustomer("Duke", 123);
    this.paymentProvider.withdrawMoneyFromCustomer("Mike", 123);

    this.storeBook("Java 11", "123-3-42-133713-4");
    this.storeBook("Java 42", "123-3-42-133713-");

    this.customerAccount.withdrawMoney(42.0);
    this.customerAccount.withdrawMoney(142.0);
  }

  public void storeBook(String bookName, String isbn) {
    if (isbnValidator.validateIsbn(isbn)) {
      logger.info("Store book with name: " + bookName);
    }
  }
}
