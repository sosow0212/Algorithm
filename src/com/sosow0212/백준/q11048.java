package com.sosow0212.백준;

import java.util.Scanner;

public class q11048 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = map[0][0];

        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int added = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = added + map[i][j];
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}
