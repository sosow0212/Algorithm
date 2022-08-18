package com.sosow0212.백준;

import java.util.Scanner;

public class q13565 {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static boolean check = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < m; i++) {
            if (graph[0][i] == 0) {
                dfs(0, i);
            }
        }

        System.out.println(check ? "YES" : "NO");

    }

    public static void dfs(int row, int col) {
        visited[row][col] = true;
        if (row == n - 1 && graph[row][col] == 0) {
            check = true;
            return;
        }

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && graph[nr][nc] == 0) {
                dfs(nr, nc);
            }
        }
    }
}
