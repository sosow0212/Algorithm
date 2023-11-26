package com.sosow0212.백준;

import java.util.Scanner;

public class q24723 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[6];

        dp[0] = 0;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 8;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] * 2;
        }

        System.out.println(dp[n]);
    }
}
