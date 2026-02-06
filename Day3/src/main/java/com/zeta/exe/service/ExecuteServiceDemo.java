package com.zeta.exe.service;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker2 implements  Runnable{
    @Override
    public void  run(){
        System.out.println("worker");
    }

}



public class ExecuteServiceDemo {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newSingleThreadExecutor();
        executor.submit(new Worker2());
        executor.shutdown();
    }
}
