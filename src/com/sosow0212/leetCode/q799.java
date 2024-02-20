package com.sosow0212.leetCode;

public class q799 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double answer = 0;

        if(poured == 0) {
            return 0.0;
        }

        double[][] dp = new double[query_row + 1][query_glass + 2];
        dp[0][0] = poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= query_glass; j++) {
                if (dp[i][j] > 1.0) {
                    double remain = dp[i][j] - 1.0; // 3.0
                    dp[i][j] = 1.0;
                    dp[i + 1][j] += remain / 2;
                    dp[i + 1][j + 1] += remain / 2;
                }
            }
        }

        answer = dp[query_row][query_glass];

        return Math.min(1.0, answer);
    }

    public static void main(String[] args) {
        q799 sol = new q799();

        // 0.18750
        System.out.println(sol.champagneTower(25, 6, 1));
    }
}
