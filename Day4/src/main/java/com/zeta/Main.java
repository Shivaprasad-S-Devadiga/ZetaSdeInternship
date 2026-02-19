package com.zeta;

import com.zeta.bank.BankAccount;
import com.zeta.bank.LoanAccount;
import com.zeta.bank.exception.Validator;
import com.zeta.bank.services.DepositTask;
import com.zeta.bank.services.WithdrawTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer , BankAccount> mapAccount = new HashMap<>() ;

        System.out.print("Enter initial bank balance: ₹");
        int initialBalance = sc.nextInt();
        Validator validate3 = (amnt)->{
            if(amnt < 0) {
                throw new IllegalArgumentException("Number should be greater than zero");
            }
        };
        validate3.validateIfNegative(initialBalance);

        BankAccount account = new BankAccount(  initialBalance, mapAccount);
        LoanAccount loan;

         //Thread pool with 3 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        while (true) {
            System.out.println("\n===== MULTITHREADED BANKING SYSTEM (ExecutorService) =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Simulate Parallel Withdrawals");
            System.out.println("5. Checking loan Approval");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            //Scanner sc = new Scanner(System.in);
            int choice = 0;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                System.out.println("You entered: " + choice);
            } else {
                System.out.println("Invalid input! Please enter a number.");
            }


            try{
                switch (choice) {

                    case 1:
                        System.out.println("Current Balance: ₹" + account.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        int deposit = sc.nextInt();
                        Validator validate = (a)->{
                            if(a < 0) {
                                throw new IllegalArgumentException("Number should be greater than zero");
                            }
                        };
                        validate.validateIfNegative(deposit);
                        //executor.execute(new DepositTask(account, dep));
                        executor.execute(()->account.deposit(100));
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ₹");
                        int withdraw = sc.nextInt();
                        //Validator.validateIfNegative(w);
                        Validator validate2 = (a)->{
                            if(a < 0) {
                               throw new IllegalArgumentException("Number should be greater than zero");
                          }
                        };
                        validate2.validateIfNegative(withdraw);
                        //executor.execute(new WithdrawTask(account, w));
                        executor.execute(()->account.withdraw(100));
                        break;

                    case 4:
                        //System.out.println("Simulating two parallel withdrawals of ₹" + (Balance / 2));
//                        executor.execute(new WithdrawTask(account, initialBalance / 2));
//                        executor.execute(new WithdrawTask(account, initialBalance / 2))
                        executor.execute(()->account.withdraw(initialBalance / 2));

                        executor.execute(()->account.withdraw(initialBalance / 2));
                        break;

                    case 5:
                        System.out.println("Checking loan Approval");
                        System.out.print("Enter loan amount and tenure(in months) ");
                        int loanAmount = sc.nextInt();
                        int tenure = sc.nextInt();
                        if (LoanAccount.loanSanction(loanAmount, tenure, account)) {
                            System.out.println("Loan sanctioned sucesfully");
                            loan = new LoanAccount(loanAmount, tenure);
                        } else {
                            System.out.println("Not eligible for loan ");
                        }
                        break;

                    case 6:
                        System.out.println("Shutting down banking system...");
                        executor.shutdown();
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }


    }
}