package de.rieckpil.udemy.decorators;

public class CustomerAccount implements Account {

    @Override
    public Double getBalance() {
        return 42.0;
    }

    @Override
    public void withdrawMoney(Double amount) {
        System.out.println("Withdraw money from customer: " + amount);
    }
}
