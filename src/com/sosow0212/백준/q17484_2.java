package com.sosow0212.백준;

import java.util.Scanner;

public class q17484_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                // 초기
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < 3; k++) {
                        dp[i][j][k] = map[i][j];
                    }
                }
                continue;
            }

            // 2줄부터
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + map[i][j];
                    continue;
                }

                if (i == m - 1) {
                    /// 마지막
                    dp[i][j][1] = dp[i - 1][j][2] + map[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i][j];
                    continue;
                }

                dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + map[i][j];
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int[] ints : dp[n - 1]) {
            answer = Math.min(ints[1], answer);
        }

        System.out.println(answer);
    }
}
