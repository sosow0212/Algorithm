package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q11722 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = max + 1;
        }

        Arrays.sort(dp);
        System.out.println(dp[n - 1]);
    }
}
