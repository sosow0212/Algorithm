package com.sosow0212.백준;

import java.util.Scanner;

public class q2193 {
    /**
     * 1자리 = 1
     * 2자리 = 1
     * 3자리 = 2
     * 4자리 = 3
     * 5자리 = 10000 10001 10010 10100 10101 == 5
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[n]);
    }
}
