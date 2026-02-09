package com.zeta.practice;

import com.zeta.bank.BankAccount;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        BankAccount account  = new BankAccount("shiv", 19, 200, 1000);
        Future future = executorService.submit(new DepositTask(account, 500));
        Future future1 = executorService.submit(new DepositTask(account , 400));
        System.out.println(future.get());
        System.out.println(future1.get());

    }
}
