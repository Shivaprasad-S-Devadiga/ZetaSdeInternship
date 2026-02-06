package com.zeta.bank.services;

import com.zeta.bank.BankAccount;

import java.util.logging.Logger;

public class DepositTask implements Runnable{
    private final BankAccount account;
    private final int amount;

    public DepositTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    Logger log = Logger.getLogger("Bank");

    @Override
    public void run() {
        String thread = Thread.currentThread().getName();
        System.out.println(thread + " depositing ₹" + amount);

        if(amount > 1000000){
            log.severe("Limit to deposit is 1000000");
        }
        account.deposit(amount);
        System.out.println(thread + " completed deposit of ₹" + amount);
        System.out.println("Total Balance " + account.getBalance() );
    }

}
