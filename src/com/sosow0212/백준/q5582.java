package com.sosow0212.백준;

import java.util.Scanner;

public class q5582 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        String a = sc.next();
        String b = sc.next();

        int n = a.length();
        int m = b.length();

        /**
         *   0 a b a a c
         * 0 0 0 0 0 0 0
         * b 0 0 1 0 0 0
         * a 0 1 0 2 1 0
         * a 0 1 0 1 3 0
         * c 0 0 0 0 0 4
         * a 0 1 0 1 1 0
         */

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
