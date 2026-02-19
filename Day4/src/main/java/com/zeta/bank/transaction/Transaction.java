package com.zeta.bank.transaction;

import com.zeta.bank.BankAccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int counter = 0;
    private  float amount;
    private String type;
    boolean transactionStatus;
    private LocalDateTime dateTime;
    BankAccount account;


    public Transaction(float amount,String type, boolean transactionStatus, LocalDateTime dateTime, BankAccount account) {
        this.amount = amount;
        this.type = type;
        this.transactionStatus = transactionStatus;
        this.dateTime = dateTime;
        this.account = account;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        //counter++;

        return "Transaction ID: " + (++counter) +
                "\nAmount: " + amount +
                "\nType: "+ type +
                "\nStatus: " + transactionStatus +
                "\nDate: " + dateTime.format(formatter) +
                "\n----------------------";
    }
}
