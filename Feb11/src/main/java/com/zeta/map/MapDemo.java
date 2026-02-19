package com.zeta.map;

import java.util.HashMap;
import java.util.Map;

class MyKey{

}



public class MapDemo {
    public static void main(String[] args) {
       customKey();
        basics();
    }
    private static void customKey(){
        Map<MyKey , String> map = new HashMap<>();
        MyKey key = new MyKey();
        MyKey key1 = new MyKey();
        map.put(key , "value1");
        map.put(key1 , "value2");
        System.out.println(map.get(key1));
        System.out.println(map);
    }

    private static  void basics(){
        Map<String , String>map = new HashMap<>();
        map.put("1" , "value1");
        //System.out.println(map.put("1" , "value2"));
        System.out.println(map.put("1", "value2"));
        map.remove(null);
        System.out.println(map.get("1"));
        System.out.println(map);
       map.forEach((key , value)->System.out.println(key));
    }

}
