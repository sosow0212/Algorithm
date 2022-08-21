package com.sosow0212.백준;

import java.util.Scanner;

public class q14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[10001];

        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 6; i <= n; i++) {
            if (dp[i - 2] == -1 && dp[i - 5] == -1) {
                dp[i] = -1;
            } else if (dp[i - 2] == -1) {
                dp[i] = dp[i - 5] + 1;
            } else if (dp[i - 5] == -1) {
                dp[i] = dp[i - 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
            }
        }
        System.out.print(dp[n]);
    }
}
