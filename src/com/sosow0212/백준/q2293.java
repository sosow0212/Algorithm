package com.sosow0212.백준;

import java.util.Scanner;

public class q2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt(); // 가치의 합

        int[] arr = new int[n + 1];
        int[] dp = new int[10001];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        /**
         *      1   2   3   4   5   6   7   8   9   10
         * 1    1   1   1   1   1   1   1   1   1   1
         * 2    0   1   1   2   2   3   3   4   4   5
         * 5    0   0   0   0   1   1   2   2   3   4
         * sum  1   2   2   3   4   5   5   7   8   10
         */

        dp[0] = 1; // n원에서 n원을 빼는 경우 즉 자기 자신을 채우는 경우가 있어서
        for (int i = 1; i <= n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[k]);


    }
}
