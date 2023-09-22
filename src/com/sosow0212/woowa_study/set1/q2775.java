package com.sosow0212.woowa_study.set1;

import java.util.Scanner;

public class q2775 {

    private static final Scanner sc = new Scanner(System.in);

    private static int[][] dp;

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            dp = new int[k + 1][n + 1];
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }

            if (k == 0) {
                System.out.println(dp[0][n]);
                continue;
            }

            for (int floor = 1; floor <= k; floor++) {
                dp[floor][1] = 1;
                for (int room = 2; room <= n; room++) {
                    dp[floor][room] = dp[floor - 1][room] + dp[floor][room - 1];
                }
            }

            System.out.println(dp[k][n]);
        }
    }
}
