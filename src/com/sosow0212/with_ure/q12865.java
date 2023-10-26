package com.sosow0212.with_ure;

import java.util.Scanner;

public class q12865 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            for (int j = 1; j <= m; j++) {
                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
            }
        }

        System.out.println(dp[n][m]);
    }
}
