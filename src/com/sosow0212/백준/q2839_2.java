package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2839_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;

        for (int i = 5; i <= n; i++) {
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;
                continue;
            }

            if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
                continue;
            }

            if (dp[i - 3] != 0 && dp[i - 5] != 0) {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }
        }

        if (dp[n] == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[n]);
    }
}
