package com.sosow0212.백준;

import java.util.Scanner;

public class q14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int T[] = new int[n + 20];
        int P[] = new int[n + 20];
        int dp[] = new int[n + 20];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[T[i] + i] = Math.max(dp[T[i] + i], P[i] + dp[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
