package com.zeta.practice;

import com.zeta.bank.BankAccount;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class DepositTask implements Callable {
    private final BankAccount account;
    private final int amount;

    public DepositTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public  Object call() throws  Exception{
        Thread.sleep((long)(Math.random()*10000));
        String thread = Thread.currentThread().getName();
        System.out.println(thread + "depositing ?"+ amount);
        account.deposit(amount);
        System.out.println(thread +"completed deposit of ? " + amount);
        return account.getBalance();
    }


}
