package com.zeta;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 3;
    private int[] arr;
    private int start, end;

    SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

     @Override
    public Integer compute(){
        if(start- end <= THRESHOLD){
            int sum=0;
            for(int i=start; i<end; i++){
              sum +=arr[i];
            }
            return sum;
        }
        else{
            int mid = (start+end)/2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);

            left.fork();
            int rightResult = right.compute();
            int leftResult = left.join();

            return leftResult + rightResult;

        }

     }

}

public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8 ,9};

        ForkJoinPool pool  = new ForkJoinPool();

        int result = pool.invoke(new SumTask(arr , 0 , arr.length));
        System.out.println("SUm is "+ result);
    }
}