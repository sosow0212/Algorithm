package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q11722_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int before = 0; before < i; before++) {
                if (arr[i] < arr[before]) {
                    dp[i] = Math.max(dp[before] + 1, dp[i]);
                }
            }
        }

        int answer = 0;
        for (int i : dp) {
            answer = Math.max(i, answer);
        }

        System.out.println(answer);
    }
}
