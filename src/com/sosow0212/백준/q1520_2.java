package com.sosow0212.백준;

import java.util.Scanner;

public class q1520_2 {

    private static final Scanner sc = new Scanner(System.in);

    private static int n, m;
    private static int[][] map;
    private static int[][] dp;
    private static boolean[][] visited;
    private static int answer = 0;
    private static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dp[n - 1][m - 1] = 1;
    }

    private static void getAnswer() {
        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    private static void dfs(int row, int col) {
        if (row == n - 1 && col == m - 1) {
            return;
        }

        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[row][col] > map[nr][nc]) {
                if (dp[nr][nc] == 0) {
                    dfs(nr, nc);
                }
                dp[row][col] += dp[nr][nc];
            }
        }
    }
}
