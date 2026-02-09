package learn.mt.priority;

public class MyThread extends Thread{

    public MyThread(String name){
        super(name);
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        //MyThread t1 = new MyThread();
        //t1.start();

        MyThread l = new MyThread("low priority");
        MyThread h = new MyThread("high priority");

        l.setPriority(10);
        h.setPriority(1);

        l.setPriority(Thread.MAX_PRIORITY);
        h.setPriority(Thread.MIN_PRIORITY);

        l.start();
        h.start();

        // priorities are only sake , execution depends o core

    }

}
