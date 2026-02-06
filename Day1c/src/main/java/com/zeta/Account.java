package com.zeta;

public interface Account {

    float deposit(float amount);

    float withdraw(float amount);

    int getNumber();

    float getBalance();

    void setBalance(float balance);

    Address getAddress();

    void setAddress(Address address);
}
