package com.zeta.assignment4;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,3, 4, 5, 6, 7};
        Sum sum = (a) ->{
            int result=0;
            for(int i=0; i<a.length; i++){
                if((i+1)%3 ==0) result +=a[i];
            }
            return result;
        };

        int ans = sum.sumMultiple3(arr);
        System.out.println("sum multiple of 3 is "+ ans);

    }
}
