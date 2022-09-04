package com.sosow0212.백준;

import java.util.Scanner;

public class q9657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 6

        // 1s 1c 4s  1 == SK, 0 == CY
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;

        // dp4 dp2 dp1 == 2 => sk
        for (int i = 5; i < dp.length; i++) {
            if (dp[i - 1] + dp[i - 3] + dp[i - 4] < 3) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }

        System.out.println(dp[n] == 1 ? "SK" : "CY");


    }
}
