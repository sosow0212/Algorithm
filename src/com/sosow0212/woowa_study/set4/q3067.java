package com.sosow0212.woowa_study.set4;

import java.util.Scanner;

public class q3067 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][10001];

        for (int i = 1; i <= n; i++) {
            int val = sc.nextInt();
            arr[i] = val;
            dp[i][val] += 1;
        }

        int m = sc.nextInt();


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - arr[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                dp[i][j] += dp[i - 1][j] + dp[i][j - arr[i]];
            }
        }

        System.out.println(dp[n][m]);
    }
}
