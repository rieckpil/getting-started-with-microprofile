package de.rieckpil.udemy.interceptors;

@SecurePayment
public class BookPaymentProvider {

    public void withdrawMoneyFromCustomer(String customerName, Integer amount) {
        System.out.println("Withdraw money from: " + customerName + " amount: " + amount);
    }

}
