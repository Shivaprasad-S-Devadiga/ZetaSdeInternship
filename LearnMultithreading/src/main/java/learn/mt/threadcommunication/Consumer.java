package learn.mt.threadcommunication;

public class Consumer implements Runnable{
    private SharedResource resource;

    public Consumer(SharedResource resource){
        this.resource = resource;
    }


    @Override
    public void run() {
        for(int i=0; i<10; i++){
            int value = resource.consumer();
        }
    }
}
