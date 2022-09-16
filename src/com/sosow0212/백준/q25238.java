package com.sosow0212.백준;

import java.util.Scanner;

public class q25238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        double sum = n * (100 - m) * 0.01;

        if(sum >= 100) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
