package com.sv.restapi.lab1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionTest2 {
    public static void main(String[] args){
        LinkedList<Integer> lst1=new LinkedList<>();
        lst1.add(20);
        lst1.add(10);
        Iterator itr=lst1.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        Iterator rlst=lst1.descendingIterator();
        while(rlst.hasNext()){
            System.out.println(rlst.next());
        }

        LinkedList<Integer> lst2=new LinkedList<>();
        lst2.add(30);
        lst2.add(40);

        lst1.addAll(lst2);
        Collections.sort(lst1);
        System.out.println(lst1);

    }
}
