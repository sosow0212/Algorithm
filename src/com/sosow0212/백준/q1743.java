package com.sosow0212.백준;

import java.util.Scanner;

public class q1743 {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int temp = 1;
    static int max = 0;

    static void dfs(int x, int y) {
        temp++;
        visited[y][x] = true;

        for (int i = 0; i < pos.length; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && graph[ny][n] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt() + 1;
        m = sc.nextInt() + 1;
        int k = sc.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();

            graph[y][x] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp = 0;
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(j, i);
                    max = Math.max(temp, max);
                }
            }
        }

        System.out.println(max);

    }
}
