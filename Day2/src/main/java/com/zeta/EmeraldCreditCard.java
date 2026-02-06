package com.zeta;

public class EmeraldCreditCard extends CreditCardBase implements ICreditCard{
    public EmeraldCreditCard(String customerName){
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
