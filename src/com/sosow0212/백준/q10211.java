package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q10211 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);
    }
}
