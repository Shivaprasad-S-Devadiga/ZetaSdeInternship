
package com.zeta;

import javax.naming.InsufficientResourcesException;
import java.util.logging.Logger;

public class Bank {
    Logger logger = Logger.getLogger("bank");
    public boolean transfer( Account account1, Account account2, float amount){
        try{
            float result = account1.withdraw(amount);
        }catch(InsufficientBalanceException  insufficientBalanceException){
            logger.severe(insufficientBalanceException.getMessage());
            return false;
        }
        account2.deposit(amount);
        return true;
    }

//    public void deposit(int amount ){
//        this.setBalance(this.getBalance()+amount);
//
//    public  boolean withdraw(int amount ){
//        if(this.getBalance() >= amount){
//            this.setBalance(this.getBalance()-amount);
//            return true;
//        }
//        else{
//            return false;
//        }
//    }



}

