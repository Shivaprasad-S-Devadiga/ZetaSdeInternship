package com.zeta.bank;

public class LoanAccount {
    int loanAmount;
    final float interest = 12.5f;
    int tenure;


    public LoanAccount(int loanAmount, int tenure) {
        this.loanAmount = loanAmount;
        this.tenure = tenure;
    }
    public static synchronized  boolean loanSanction(int loanAmount, int tenure, BankAccount account) {
       if(account.getBalance() >= 100000 && account.income > 500000 && account.age > 18)
           return true;

       return false;
    }
}
