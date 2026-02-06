package com.zeta;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account account= new SavingAccount(123);
        account.setBalance(500);

        Account current = new CurrentAccount(999);
        current.setBalance(200);


//        List<Account> accounts = new ArrayList<>();
//        accounts.add(account);
//        accounts.add(current);
//        accounts.forEach(account1 -> {
//            account1.deposit(2000);
//        });


        Account a1= new SavingAccount(1);
        Account a2= new SavingAccount(2);
        a1.setBalance(50000);

        Bank bank = new Bank();
        if(bank.transfer(a1, a2 , 500)){
            System.out.println("account sucessfully transfered");
            System.out.println("a1 balance : " + a1.getBalance());
            System.out.println("a2 balance : " + a2.getBalance());
        }




    }
}