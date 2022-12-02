package com.sosow0212.백준;

import java.util.Scanner;

public class q1520 {
    static int n, m;
    static int[][] map, dp;
    static boolean[][] visited;
    static int answer = 0;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m + 1][n + 1];
        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        dfs(1,1);
        System.out.println(dp[m][n]);
    }

    public static int dfs(int row, int col) {
        if (row == m && col == n
        ) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = 0;
        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if(nr < 1 || nr > m || nc < 1 || nc <n) {
                continue;
            }

            if(map[row][col] > map[nr][nc]) {
                dp[row][col] += dfs(nr, nc);
            }
        }

        return dp[row][col];
    }
}
