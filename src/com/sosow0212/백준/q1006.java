package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class q1006 {
    private static int[][] dp;
    private static int[][] choragi;
    private static int n, w;
    static int top = 0, bottom = 1, both = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int caseNum = 0; caseNum < testCase; caseNum++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]) * 2;
            w = Integer.parseInt(input[1]);
            choragi = new int[2][n / 2 + 1];

            for (int i = 0; i < 2; i++) {
                String[] parts = br.readLine().split(" ");
                for (int j = 0; j < parts.length; j++) {
                    choragi[i][j + 1] = Integer.parseInt(parts[j]);
                }
            }

            if (n == 2) {
                int temp = choragi[top][1] + choragi[bottom][1] <= w ? 1 : 2;
                System.out.println(temp);
                continue;
            }

            int temp = Integer.MAX_VALUE;

            dp = new int[3][n / 2 + 1];
            dp[top][1] = 1;
            dp[bottom][1] = 1;
            dp[both][1] = choragi[top][1] + choragi[bottom][1] <= w ? 1 : 2;
            handleCase();
            temp = min(temp, dp[both][n / 2]);

            if (choragi[top][1] + choragi[top][n / 2] <= w) {
                dp = new int[3][n / 2 + 1];
                dp[top][1] = 1;
                dp[bottom][1] = Integer.MAX_VALUE;
                dp[both][1] = 2;
                dp[both][0] = Integer.MAX_VALUE;
                handleCase();
                temp = min(temp, dp[bottom][n / 2]);
            }

            if (choragi[bottom][1] + choragi[bottom][n / 2] <= w) {
                dp = new int[3][n / 2 + 1];
                dp[bottom][1] = 1;
                dp[top][1] = Integer.MAX_VALUE;
                dp[both][1] = 2;
                dp[both][0] = Integer.MAX_VALUE;
                handleCase();
                temp = min(temp, dp[top][n / 2]);
            }

            if (choragi[top][1] + choragi[top][n / 2] <= w
                    && choragi[bottom][1] + choragi[bottom][n / 2] <= w) {
                dp = new int[3][n / 2 + 1];
                dp[top][1] = dp[bottom][1] = Integer.MAX_VALUE;
                dp[both][1] = 2;
                dp[both][0] = Integer.MAX_VALUE;
                handleCase();
                temp = min(temp, dp[both][n / 2 - 1]);
            }

            System.out.println(temp);
        }
    }

    public static void handleCase() {
        for (int i = 2; i <= n / 2; i++) {
            dp[top][i] = dp[both][i - 1] + 1;
            if (choragi[top][i - 1] + choragi[top][i] <= w) {
                dp[top][i] = min(dp[bottom][i - 1] + 1, dp[top][i]);
            }

            dp[bottom][i] = dp[both][i - 1] + 1;
            if (choragi[bottom][i - 1] + choragi[bottom][i] <= w) {
                dp[bottom][i] = min(dp[top][i - 1] + 1, dp[bottom][i]);
            }

            dp[both][i] = min(dp[top][i] + 1, dp[bottom][i] + 1);
            if (choragi[top][i] + choragi[bottom][i] <= w) {
                dp[both][i] = min(dp[both][i - 1] + 1, dp[both][i]);
            }

            if (choragi[top][i - 1] + choragi[top][i] <= w && choragi[bottom][i - 1] + choragi[bottom][i] <= w) {
                dp[both][i] = min(dp[both][i - 2] + 2, dp[both][i]);
            }
        }
    }
}
