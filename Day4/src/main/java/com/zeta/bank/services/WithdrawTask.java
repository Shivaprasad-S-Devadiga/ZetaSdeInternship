package com.zeta.bank.services;

import com.zeta.bank.BankAccount;

import java.util.logging.Logger;

public class WithdrawTask implements Runnable{
    private final BankAccount account;
    private final int amount;

    public WithdrawTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    Logger log = Logger.getLogger("Bank");

    @Override
    public void run() {
        String thread = Thread.currentThread().getName();
        System.out.println(thread + " attempting to withdraw ₹" + amount);

        boolean success = account.withdraw(amount);

        if(amount >200000){
            log.severe("Maximum withdraw 200000");
        }

        if (success) {
            System.out.println(thread + " successfully withdrew ₹" + amount);
        } else {
            System.out.println(thread + " FAILED to withdraw ₹" + amount + " (Insufficient balance)");
        }

    }

}
