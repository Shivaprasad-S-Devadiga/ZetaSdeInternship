package com.zeta.bank;

import java.util.logging.Logger;

public class BankAccount {
    private  float balance;

    Logger log = Logger.getLogger("Bank account");

    public BankAccount(float balance) {
        if(balance<0) {
           log.severe("Initial Balance should greater than 0.00");
           return;
        }
        this.balance = balance;
    }

    public synchronized float getBalance() {
        return balance;
    }

    public synchronized boolean withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " checking balance...");

        if (balance >= amount) {
            try { Thread.sleep(500); } catch (InterruptedException e) {}

            balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized void deposit(int amount) {
        try { Thread.sleep(300); } catch (InterruptedException e) {}

        balance += amount;
    }

}
