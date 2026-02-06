package com.zeta.bank;

import java.util.logging.Logger;

public class BankAccount {
    String name;
    int age ;
    int income;
    private  float balance;

    Logger log = Logger.getLogger("Bank account");

    public BankAccount(String name, int age, int income, float balance) {
        this.name = name;
        this.age = age;
        this.income = income;
        this.balance = balance;
    }


    public synchronized float getBalance() {

        return balance;
    }

    public  synchronized  boolean withdraw(int amount) {
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
