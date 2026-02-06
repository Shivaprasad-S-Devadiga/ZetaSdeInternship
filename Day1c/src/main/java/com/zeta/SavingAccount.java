package com.zeta;

import java.text.MessageFormat;

public class SavingAccount implements Account {

    private float balance;        // mutable
    private final int number;     // immutable
    private Address address;

    public SavingAccount(int number) {
        this.number = number;
    }

    @Override
    public float deposit(float amount) {
        balance += amount;
        return balance;
    }

    @Override
    public float withdraw(float amount) {
        if (balance < amount) {
            String msg = MessageFormat.format("Current Balance = {0}, Requesting amount = {1}",this.getBalance(), amount);
            throw new InsufficientBalanceException(
                    msg
            );
        }
        balance -= amount;
        return balance;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public float getBalance() {
        return balance;
    }

    @Override
    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }
}
