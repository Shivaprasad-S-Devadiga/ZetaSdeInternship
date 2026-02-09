package com.zeta.lambdacollection;


public interface Account {

    float deposit(float amount);

    float withdraw(float amount);

    int getNumber();

    float getBalance();

    void setBalance(float balance);

}

