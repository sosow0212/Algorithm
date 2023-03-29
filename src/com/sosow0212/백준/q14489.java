package com.sosow0212.백준;

import java.util.Scanner;

public class q14489 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int price = sc.nextInt() * 2;
        int sum = a + b;

        if(price > sum) {
            System.out.println(sum);
            return;
        }

        System.out.println(sum - price);
    }
}
