package com.zeta;

public interface ICreditCard {
    boolean transaction(MerchantAccount account , int amount);
    boolean withdraw(int amount);
}
