package com.sv.restapi.lab1;

import java.util.Scanner;

public class SvUtil {
    public int sum1() {
        int total=0;
        Scanner num = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a Number");
            int number=num.nextInt();
            if(number==0) {
                return total;
            }else{
                total+=number;
            }

        }
    }
}
