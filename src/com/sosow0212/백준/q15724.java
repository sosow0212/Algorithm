package com.sosow0212.백준;

import java.util.Scanner;

public class q15724 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] + arr[i - 1][j - 1] - dp[i - 1][j - 1];
            }
        }

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            sb.append(dp[c][d] - dp[c][b - 1] - dp[a - 1][d] + dp[a - 1][b - 1])
                    .append("\n");
        }

        System.out.println(sb.toString());
    }
}
