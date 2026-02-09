package com.zeta.lambdacollection;

import java.util.ArrayList;
import java.util.List;

public class LambdaWithCollection {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        //Account[] acc = new Account[10];

        for (int i = 0; i < 10; i++) {
           accounts.add(new SavingsAccount(i+1));
        }

        accounts.forEach((account) -> System.out.println(account.getNumber()));
        System.out.println("After sorting  -------");
        accounts.sort((Account account1 , Account account2) -> account2.getNumber() - account1.getNumber());
        accounts.forEach((account) -> System.out.println(account.getNumber()));

        System.out.println("Even account number remove  -------");
        accounts.removeIf(account -> account.getNumber()%2 ==0);
        accounts.forEach((account) -> System.out.println(account.getNumber()));
    }
}
