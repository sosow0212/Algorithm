package com.sosow0212.백준;

import java.util.Scanner;

public class q10768 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = 2;
        int day = 18;

        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a > month) {
            System.out.println("After");
        } else if(a == month && b > day) {
            System.out.println("After");
        } else if(a == month && b == day) {
            System.out.println("Special");
        } else {
            System.out.println("Before");
        }
    }
}
