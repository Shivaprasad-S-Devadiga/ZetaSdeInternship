package learn.mt.threadcommunication;

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread p1 = new Thread(new Producer(resource));
        Thread c1 = new Thread(new Consumer(resource));

        p1.start();
        c1.start();

    }
}
