package com.zeta;

public class CurrentAccount implements Account {

    private float balance;
    private final int number;
    private Address address;

    public CurrentAccount(int number) {
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
            throw new InsufficientBalanceException(
                    "Current balance less than amount"
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
