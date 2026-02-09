package com.zeta.bank.exception;

public interface Validator{
//    public static  void validateIfNegative(int amount){
//        if(amount<0) {
//            throw new IllegalArgumentException("Number should be greater than zero");
//        }
//    }

    void validateIfNegative(int Balance);

}
