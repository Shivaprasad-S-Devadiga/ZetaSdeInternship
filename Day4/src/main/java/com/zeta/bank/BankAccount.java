package com.zeta.bank;

import com.zeta.bank.transaction.Transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class BankAccount {
//    String name;
//    int age ;
//    int income;
    static int accountNumberCounter=1010;
    private int accountNumber;
    private  float balance;
    List<Transaction> transactionList = new ArrayList<>();

    Logger log = Logger.getLogger("Bank account");

    public BankAccount(  float balance, Map<Integer , BankAccount> mapAccount)
    {
        this.accountNumber = (++accountNumberCounter);
        this.balance = balance;
        mapAccount.put(this.accountNumber , this);
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    public synchronized float getBalance() {

        return balance;
    }

    public  boolean payAmount(BankAccount account2 , int amount){
        if(this.balance >= amount){
            this.balance -=amount;
            account2.balance += amount;
            Transaction debitTransaction = new Transaction(amount ,"debit" ,true , LocalDateTime.now(), account2);
            this.transactionList.add(debitTransaction);
            Transaction creditTransaction = new Transaction(amount ,"credit" ,true , LocalDateTime.now(), this);
            account2.transactionList.add(debitTransaction);
            return  true;
        }
        Transaction debitTransaction = new Transaction(amount ,"debit", false , LocalDateTime.now(), account2);
        this.transactionList.add(debitTransaction);
        return false;
    }



    public  synchronized  boolean withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " checking balance...");

        if (balance >= amount) {
            try { Thread.sleep(500); } catch (InterruptedException e) {}

            balance -= amount;
            Transaction debitTransaction = new Transaction(amount ,"debit" ,true , LocalDateTime.now(), this);
            this.transactionList.add(debitTransaction);
            return true;
        }
        return false;
    }

    public synchronized void deposit(int amount) {
        try { Thread.sleep(300); } catch (InterruptedException e) {}

        balance += amount;
        Transaction debitTransaction = new Transaction(amount ,"credit" ,true , LocalDateTime.now(), this);
        this.transactionList.add(debitTransaction);
    }

    public  void transactionDetails(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        this.transactionList.forEach(transaction -> {
            System.out.println(transaction.toString());
        });

    }


}
