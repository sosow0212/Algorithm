package com.sosow0212.백준;

import java.util.Scanner;

public class q11052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int now = 1; now <= n; now++) {
            for (int before = 1; before <= now; before++) {
                dp[now] = Math.max(
                        dp[now],
                        dp[now - before] + arr[before]
                );
            }
        }

        System.out.println(dp[n]);
    }
}
