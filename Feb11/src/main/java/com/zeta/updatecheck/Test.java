package com.zeta.updatecheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        new Thread(()->{
            list.add("D");
        }).start();

        list.add("A");
        list.add("B");
        list.add("C");

        for(String s : list){
            if ((s.equals("B"))){ list.remove(s); }
        }

        System.out.println(list);
    }

}
