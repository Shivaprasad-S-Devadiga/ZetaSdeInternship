package com.zeta;

public class InfiniaCreditCard extends CreditCardBase implements ICreditCard{

    public InfiniaCreditCard(String customerName){
        super(customerName);
    }


    @Override
    public boolean transaction(MerchantAccount account, int amount) {
        return false;
    }

    @Override
    public boolean withdraw(int amount) {
        return false;
    }
}