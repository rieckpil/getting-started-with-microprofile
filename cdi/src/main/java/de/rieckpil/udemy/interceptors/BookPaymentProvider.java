package de.rieckpil.udemy.interceptors;

public class BookPaymentProvider {

    @SecurePayment
    public void withdrawMoneyFromCustomer(String customerName, Integer price) {

        // withdraw money

    }

}
