package de.rieckpil.udemy.interceptors;

import javax.interceptor.Interceptors;

@Interceptors(BookPaymentInterceptor.class)
public class BookPaymentProvider {

    public void withdrawMoneyFromCustomer(String customerName, Integer amount) {
        System.out.println("Withdraw money from: " + customerName + " amount: " + amount);
    }

}
