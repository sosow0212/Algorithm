package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q16973 {

    static int n;
    static int m;
    static int h;
    static int w;
    static int startRow;
    static int startCol;
    static int endRow;
    static int endCol;
    static int[][] map;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        h = sc.nextInt();
        w = sc.nextInt();
        startRow = sc.nextInt() - 1;
        startCol = sc.nextInt() - 1;
        endRow = sc.nextInt() - 1;
        endCol = sc.nextInt() - 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc])) {
                    continue;
                }

                if (!hasInnerPoint(nr, nc)) {
                    continue;
                }

                visited[nr][nc] = true;
                dp[nr][nc] = dp[now[0]][now[1]] + 1;
                q.add(new int[]{nr, nc});
            }
        }

        System.out.println(dp[endRow][endCol]);
    }

    static boolean hasInnerPoint(int row, int col) {
        for (int i = row; i < row + h; i++) {
            for (int j = col; j < col + w; j++) {
                if (i < 0 || j < 0 || i >= n || j >= m || map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
