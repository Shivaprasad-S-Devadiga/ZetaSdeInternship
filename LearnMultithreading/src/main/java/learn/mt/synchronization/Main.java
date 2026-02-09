package learn.mt.synchronization;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        t1.start();
        MyThread t2 = new MyThread(counter);
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.getCount());

    }
}
