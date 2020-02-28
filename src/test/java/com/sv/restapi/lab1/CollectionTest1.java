package com.sv.restapi.lab1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionTest1 {
    public static void main(String[] args){

        Collection<Integer> items=new ArrayList<>();
        items.add(10);
        items.add(20);
        items.add(30);
        System.out.println(items);
        try {
            List<Integer> items2 = new ArrayList<>();
            items2.add(100);
            items2.add(200);
            items2.add(300);
            System.out.println(items2.get(0));
            System.out.println(items2.get(2));
            System.out.println(items2.get(1));
            System.out.println(items2.get(3));
        } catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
