package learn.mt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Worker w1 = new Worker();
        w1.start();

        for (int i=0; i<4; i++){
            System.out.println("HEllo " + Thread.currentThread().getName());

        }
    }
}