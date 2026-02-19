package com.zeta.bank.transaction;

import com.zeta.bank.BankAccount;
import com.zeta.bank.exception.Validator;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TransactionDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<Integer, BankAccount> mapAccount = new HashMap<>();
        Logger log = Logger.getLogger("BANK");

        while (true) {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Create bank account");
            System.out.println("2. Pay to other account");
            System.out.println("3.Transaction Details");
            System.out.println("4. Account details");
            System.out.println("5, Deposit");
            System.out.println("6. Withdrawal");
            System.out.println("7. exit");

            try {
                int choice = 0;
                System.out.println("Enter your choice");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    System.out.println("You entered: " + choice);
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                }

                switch (choice) {

                    case 1:
                        System.out.println("Enter initial balance");
                        int initialBalance = sc.nextInt();
                        Validator validate = (a) -> {
                            if (a < 0) {
                                throw new IllegalArgumentException("Number should be greater than zero");
                            }
                        };
                        validate.validateIfNegative(initialBalance);
                        BankAccount account = new BankAccount(initialBalance, mapAccount);
                        System.out.println("Account created Successfully , your account number " + account.getAccountNumber() + ". Account Balance " + account.getBalance());
                        break;

                    case 2:
                        System.out.println("Enter sender account number");
                        int sender = sc.nextInt();
                        if (!mapAccount.containsValue(sender)) {
                            throw new IllegalArgumentException("Account number doesn't exist");
                        }
                        System.out.println("Enter receiver account number");
                        int receiver = sc.nextInt();
                        if (!mapAccount.containsValue(receiver)) {
                            throw new IllegalArgumentException("Account number doesn't exist");
                        }
                        System.out.println("Enetr the amount ");
                        int amount = sc.nextInt();
                        Validator validate2 = (a) -> {
                            if (a < 0) {
                                throw new IllegalArgumentException("Number should be greater than zero");
                            }
                        };
                        validate2.validateIfNegative(amount);
                        System.out.println("payment processing");
                        if (mapAccount.get(sender).payAmount(mapAccount.get(receiver), amount)) {
                            System.out.println("transaction successfully Done");
                        } else {
                            System.out.println("Transaction Failed");
                        }
                        break;

                    case 3:
                        System.out.println("Enter account number");
                        int accountNUmber = sc.nextInt();
                        System.out.println("\n\ntransaction Details");
                        //System.out.println("sl     "+"account number   "+"Type    "+"amount    "+"transaction status"+"Date and time");
                        mapAccount.get(accountNUmber).transactionDetails();
                        break;

                    case 4:
                        System.out.println("Listed Accounts");
                        mapAccount.forEach((key, value) -> System.out.println("AccountNumber " + key + "  " + " -> Account Balance " + value.getBalance()));
                        break;


                    case 5:
                        System.out.println("eneter your account number");
                        int depositAccountNumber = sc.nextInt();
                        if (!mapAccount.containsValue(depositAccountNumber)) {
                            throw new IllegalArgumentException("Account number doesn't exist");
                        }
                        System.out.println("Enter amount to deposit");
                        int depositAmount = sc.nextInt();
                        executor.execute(() -> (mapAccount.get(depositAccountNumber)).deposit(depositAmount));
                        break;

                    case 6:
                        System.out.println("eneter your account number");
                        int withdrawalAccountNumber = sc.nextInt();
                        if (!mapAccount.containsValue(withdrawalAccountNumber)) {
                            throw new IllegalArgumentException("Account number doesn't exist");
                        }
                        System.out.println("Enter amount to deposit");
                        int withdrawAmount = sc.nextInt();
                        executor.execute(() -> (mapAccount.get(withdrawalAccountNumber)).withdraw(withdrawAmount));
                        break;


                    case 7:
                        System.out.println("sure ,you want to exit y/n");
                        char input = sc.next().charAt(0);
                        if (input == 'y') {
                            System.exit(0);
                        }
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;

                }
            } catch (Exception e) {
                log.severe(e.getMessage() == null ? "something went wrong" : e.getMessage());
            }
        }


    }
}


