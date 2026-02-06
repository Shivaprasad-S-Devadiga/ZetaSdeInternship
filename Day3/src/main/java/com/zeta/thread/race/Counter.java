package com.zeta.thread.race;

class Counter {
    int count=0;

     void increment(){
         System.out.println("inside "+count);
        synchronized (this){
            for (; ;)
                count++;
        }
    }

    synchronized int getValue(){
         return count;
    }


}
