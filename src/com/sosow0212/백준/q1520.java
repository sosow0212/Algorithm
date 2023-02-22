package com.sosow0212.백준;

import java.util.Scanner;

public class q1520 {
    static int n, m;
    static int[][] map, dp;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        dfs(1, 1);
        System.out.println(dp[n - 1][m - 1]);
    }

    public static int dfs(int row, int col) {
        if (row == m && col == n) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = 0;
        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr < 1 || nr > m || nc < 1 || nc < n) {
                continue;
            }

            if (map[row][col] > map[nr][nc]) {
                dp[row][col] += dfs(nr, nc);
            }
        }

        return dp[row][col];
    }
}
