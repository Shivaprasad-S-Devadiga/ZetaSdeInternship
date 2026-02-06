package com.zeta.thread.race;

public class Worker1 extends Thread {
    private  Counter counter;

    public Worker1(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run(){
        counter.increment();
    }

}
