package com.sv.restapi.lab1;

import java.lang.reflect.Array;

public class Test1 {

    public int add(int[] num){
        int sum=0;
        for(int n:num){
            sum+=n;
        }
//        for(int i=0;i<num.length;++i){
//            sum=sum+num[i];
//        }
        return sum;
    }
    public static void main(String[] args){
//        System.out.println("Hello");
//        int[] num = null;
//        num= new int[]{1, 2, 3, 4,5};
//        System.out.println(num.length);
//        for (int i=0;i<num.length;++i){
//            System.out.println(num[i]);
//        }
        Test1 obj=new Test1();
        System.out.println(obj.add(new int[]{1,2,3,4,5}));
        int[] num2={1,2,3,4,5,6};
        int sum=0;
        for(int num:num2){
            sum+=num;
        }
        System.out.println(sum);
        SvUtil obj2=new SvUtil();
        System.out.println("sum of numbers:"+obj2.sum1());
    }

}
