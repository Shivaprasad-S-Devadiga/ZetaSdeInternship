package com.zeta.thread.race;

import com.zeta.thread.race.Counter;

public class RaceDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Worker1(counter);

        t1.start();

        System.out.println("1-"+counter.getValue());

        Thread t2 = new Worker1(counter);
        //t1.join();
        System.out.println("2-"+counter.getValue());

        t2.start();
        //t2.join();
        System.out.println("3-"+counter.getValue());
    }
}
