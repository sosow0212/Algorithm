package com.sosow0212.백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q14940 {

    static int n, m;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] start;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        initData();
        bfs(start[0], start[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -2) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (isValidRange(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0 && dp[nr][nc] < 0) {
                    q.add(new int[]{nr, nc});
                    dp[nr][nc] = dp[now[0]][now[1]] + 1;
                    visited[nr][nc] = true;
                }
            }
        }
    }

    private static boolean isValidRange(final int nr, final int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        visited = new boolean[n][m];
        start = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = map[i][j] != 0 ? -1 : -2;
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                    dp[i][j] = 0;
                }
            }
        }
    }
}
