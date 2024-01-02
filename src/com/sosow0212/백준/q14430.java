package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q14430 {

    static int n;
    static int m;
    static int[][] map;
    static int[][] dp;
    static int[][] pos = {{0, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }

        System.out.println(dp[n][m]);
    }
}
