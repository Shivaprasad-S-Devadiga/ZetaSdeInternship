package com.zeta.function;

import java.util.function.BiFunction;
import java.util.function.Function;

class Util{
    int sqaure(int x){
        return x*x;
    }

    static  int sum(int x, int y){
        return x+y;
    }


}


public class MethodReference {
    public static void main(String[] args) {
        //Util.sqaure(3);

        Util util = new Util();
        Function<Integer, Integer> ref = util::sqaure;
        System.out.println(ref.apply(3));

        BiFunction<Integer, Integer, Integer> re2 = Util::sum;
        System.out.println(re2.apply(3, 4));

    }
}
