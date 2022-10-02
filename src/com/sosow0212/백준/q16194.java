package com.sosow0212.백준;

import java.util.Scanner;

public class q16194 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[1001];
        int[] dp = new int[10001];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i]; // 최소값 초기화.
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
