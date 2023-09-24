package com.sosow0212.woowa_study.set3;

import java.util.Scanner;

public class q2688 {

    private static final Scanner sc = new Scanner(System.in);
    private static long[][] dp;

    public static void main(String[] args) {
        dp = new long[65][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[n][i];
        }

        System.out.println(answer);
    }
}
