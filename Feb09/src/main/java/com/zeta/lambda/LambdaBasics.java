package com.zeta.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaBasics {
    static Predicate<Double> predicate = (x) -> x % 2 == 0;
    static Consumer<String> Consumerlambda = messege -> System.out.println(messege);

    public static void main(String[] args) {
//        Consumerlambda.accept("HI");
//        System.out.println(predicate.test(10.1));

//         Calculater calculater = (a, b) -> (a + b);
//        System.out.println("sum is "+ calculater.add(3, 4));

        int[] arr = { 2, 4, 6, 8};
        Sum sum = (a) ->{
            for(int i=0; i<4; i++){
                a[i] = a[i] +2;
            }
            return a;
        };

        int[] resultArr = sum.addTwo(arr);
        for(int i=0; i< arr.length; i++){
            System.out.print(resultArr[i] +" ");
        }

        System.out.println();

        int[] arr2 = {3, 4, 5,6 };
        EvenIncrement evenIncrement = (a1, x)->{
            for(int i=0; i<4; i++){
                if(a1[i] %2 ==0){
                    a1[i] +=x;
                }
            }
            return a1;
        };

        int[] resultarr2 = evenIncrement.evenIncrementby2(arr2, 10);
        for(int i=0; i< arr.length; i++){
            System.out.print(resultarr2[i] +" ");
        }


  }
}
