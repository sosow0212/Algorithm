package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class q12852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                int min = Math.min(dp[i / 2], dp[i / 3]);
                dp[i] = Math.min(dp[i], min) + 1;
                continue;
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
            }

            if (i % 2 != 0 && i % 3 != 0) {
                dp[i] = Math.min(dp[i], dp[i - 1]) + 1;
            }
        }

        System.out.println(dp[n]);
    }
}
