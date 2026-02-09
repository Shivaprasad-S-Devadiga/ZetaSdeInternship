package learn.mt.threadcommunication;

public class SharedResource {
    private  int data;
    private boolean hasdata;

    public synchronized void producer(int value){
       while(hasdata){
           try{
               wait();
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
           }
       }
        data = value;
       hasdata = true;
        System.out.println("Produced " + value);
        notify();

    }

    public synchronized int consumer(){
        while( !hasdata) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasdata = false;
        System.out.println("Consumed " + data);
        notify();
        return data;
    }
}
