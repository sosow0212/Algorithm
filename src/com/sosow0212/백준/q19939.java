package com.sosow0212.백준;

import java.util.Scanner;

public class q19939 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] baskets = new int[k];

        int base = (n - ((k * (k + 1)) / 2));
        if (base < 0) {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i < baskets.length; i++) {
            baskets[i] = (base / k);
            n -= (base / k);
        }
        if (n == ((k * (k + 1)) / 2)) {
            System.out.println(k - 1);
        } else {
            System.out.println(k);
        }
    }
}