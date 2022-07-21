package com.sosow0212.백준;

import java.util.Scanner;

public class q1075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();

        n = (n/100) * 100;

        while(n%f != 0) {
            n ++;
        }

        n %= 100;

        if(n < 10)
            System.out.println("0" + n);
        else
            System.out.println(n);
    }
}
