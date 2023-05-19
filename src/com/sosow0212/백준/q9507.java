package com.sosow0212.백준;

import java.util.Scanner;

public class q9507 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        long[] dp = new long[68];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }

        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
