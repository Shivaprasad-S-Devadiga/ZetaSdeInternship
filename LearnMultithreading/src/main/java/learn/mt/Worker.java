package learn.mt;

public class Worker extends Thread{


    @Override
    public void run() {
        for (int i=0; i<4; i++){
            System.out.println("HEllo " + Thread.currentThread().getName());

        }
    }
}
