package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q20300 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long max = Integer.MIN_VALUE;

        if (n % 2 == 0) {
            for (int i = 0; i < n / 2 + 1; i++) {
                long sum = arr[i] + arr[n - i - 1];
                max = Math.max(sum, max);
            }
        } else {
            max = arr[n - 1];

            for (int i = 0; i < n / 2 + 1; i++) {
                long sum = arr[i] + arr[n - i - 2];
                max = Math.max(sum, max);
            }
        }

        System.out.println(max);
    }
}
