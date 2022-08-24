package com.sosow0212.백준;

import java.util.Scanner;

public class q2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int sum = 0;

        while (start < n) {
            if (sum > m || end == n) sum -= arr[start++];
            else sum += arr[end++];

            if (sum == m) count++;
        }

        System.out.println(count);
    }
}
