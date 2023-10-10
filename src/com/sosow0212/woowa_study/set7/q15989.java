package com.sosow0212.woowa_study.set7;

import java.util.Scanner;

public class q15989 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] dp = new int[10001][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        dp[4][1] = 1;
        dp[4][2] = 2;
        dp[4][3] = 1;

        dp[5][1] = 1;
        dp[5][2] = 2;
        dp[5][3] = 2;

        for (int i = 6; i < dp.length; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }

    }
}
