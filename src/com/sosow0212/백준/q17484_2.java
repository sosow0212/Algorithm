package com.sosow0212.백준;

import java.util.Scanner;

public class q17484_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[][][] dp = new int[3][n][m];

        for (int col = 0; col < m; col++) {
            dp[0][0][col] = map[0][col];

            for (int row = 0; row < n; row++) {

            }
        }
    }
}
