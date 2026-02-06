package com.zeta;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
     super(message);
    }
}
