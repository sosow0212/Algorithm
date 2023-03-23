package com.sosow0212.boj_replay;

import java.util.Scanner;

public class q1464 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        /**
         * 2 -> 1*2
         * 3 -> 1*3
         * 4 -> (2)*2
         * 5 -> *3 *(2)
         */

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
    }
}
