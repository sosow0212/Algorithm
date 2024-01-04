package com.sosow0212.백준;

import java.util.Scanner;

public class q2240 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int w = sc.nextInt();
        int[][] dp = new int[t + 1][w + 1];
        int answer = 0;

        for (int i = 1; i <= t; i++) {
            int treeIdx = sc.nextInt();

            for (int j = 0; j <= w; j++) {
                if (j == 0) {
                    if (treeIdx == 1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if (j % 2 == 0) {
                    // tree = 홀수 idx
                    if (treeIdx == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    }
                } else {
                    // 짝수
                    if (treeIdx == 1)
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    else
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                }
            }
        }

        for (int i = 0; i <= w; i++) {
            answer = Math.max(answer, dp[t][i]);
        }

        System.out.println(answer);
    }
}
