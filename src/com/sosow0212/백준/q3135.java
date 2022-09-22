package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q3135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int min = Math.abs(a - b);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(Math.abs(b - arr[i]) + 1, min);
        }

        System.out.println(min);

    }
}
