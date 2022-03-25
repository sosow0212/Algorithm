package com.sosow0212.백준;

import java.util.Scanner;

public class q1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            dp[i] = i;
            for(int j = 1; j*j <= i; j++)
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
        }

        System.out.println(dp[n]);
    }
}