package com.test.exam01;

import java.util.Arrays;

public class ForExam {

    public static void main(String[] argv) {

        System.out.println("Integer size = " + Integer.SIZE);
        System.out.println("Byte size = " + Byte.SIZE);
        System.out.println("Short size = " + Short.SIZE);

        System.out.println("Long size = " + Long.SIZE);
        System.out.println("Float size = " + Float.SIZE);
        System.out.println("Double size = " + Double.SIZE);

        int[ ] a = {1, 2, 3, 4, 5};
        String[] str = new String[]{"Kim", "Park", "Lee"};

        for(int i=0; i<a.length; i++)
            System.out.print(a[i] + "\t");

        for(String s:str) System.out.print(s + "\t");

        System.out.println(Arrays.toString(str));

        //1
        int sum = 0;
        for(int i=1; i<=100; sum+=i++);
        System.out.println("\n" + "a1 sum = " + sum);

        //2
        int i = 1;
        sum = 0;
        while(true) {

            sum += i++;
            if(i>100) break;
        }
        System.out.println("a2 sum = " + sum);

        //3
        i = 1; sum = 0;
        while(i<=100) sum += i++;
        System.out.println("a3 sum = " + sum);

        //4
        i=1; sum=0;
        while(true) {
            sum += i++;
            if(i<=100) continue;
            else break;
        }
        System.out.println("a4 sum = " + sum);

        //5
        i=1; sum = 0;
        do {
            sum += i++;
        }while(i<=100);
        System.out.println("a5 sum = " + sum);
    }
    
}
