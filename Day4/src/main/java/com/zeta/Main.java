package com.zeta;

import com.zeta.bank.BankAccount;
import com.zeta.bank.services.DepositTask;
import com.zeta.bank.services.WithdrawTask;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial bank balance: ₹");
        int initialBalance = sc.nextInt();

        BankAccount account = new BankAccount(initialBalance);

        // Thread pool with 3 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(3);



        while (true) {
            System.out.println("\n===== MULTITHREADED BANKING SYSTEM (ExecutorService) =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Simulate Parallel Withdrawals");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    int dep = sc.nextInt();
                    executor.execute(new DepositTask(account, dep));
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    int w = sc.nextInt();
                    executor.execute(new WithdrawTask(account, w));
                    break;

                case 4:
                    System.out.println("Simulating two parallel withdrawals of ₹" + (initialBalance / 2));

                    executor.execute(new WithdrawTask(account, initialBalance / 2));
                    executor.execute(new WithdrawTask(account, initialBalance / 2));

                    break;

                case 5:
                    System.out.println("Shutting down banking system...");
                    executor.shutdown();
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }


    }
}