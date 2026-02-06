package com.zeta;

public class Worker extends Thread{
    public Worker(String name){
        super(name);
    }

    public  void run(){
        for(int i=1; i<5; i++){
            try{
                System.out.println("thread= " +Thread.currentThread());
                Thread.sleep(1000);
                //throw new RuntimeException();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
