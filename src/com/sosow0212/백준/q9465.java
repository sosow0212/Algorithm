package com.sosow0212.백준;

import java.util.Scanner;

public class q9465 {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int[][] arr = new int[2][n + 1];
        int[][] dp = new int[2][n + 1];

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][1] = arr[0][1];
        dp[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i];
        }

        int answer = Math.max(dp[0][n], dp[1][n]);
        System.out.println(answer);
    }
}
