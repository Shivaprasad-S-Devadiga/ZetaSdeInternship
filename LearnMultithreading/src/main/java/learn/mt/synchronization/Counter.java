package learn.mt.synchronization;

public class Counter {
    private int count=0;

    public synchronized void increment(){
        synchronized (this){
            count++;
        }
    }

    public int getCount(){
        return count;
    }


}
