package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q11060 {

    private static final int MAX = 1001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, MAX);

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j < i + 1 + arr[i]; j++) {
                if (j > n) {
                    break;
                }

                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }

        System.out.println(dp[n] == MAX ? -1 : dp[n]);
    }
}
