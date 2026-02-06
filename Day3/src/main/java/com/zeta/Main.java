package com.zeta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        Worker w0 = new Worker("staff1");
        //w0.setPriority(2);
        w0.start();
        try{
           w0.wait(3000);

        }catch(Exception e){
            System.out.println(e.getMessage());
       }

        Worker w1 = new Worker("staff2");
        //w1.setPriority(1);
        w1.start();
        w1.yield();
    }
}