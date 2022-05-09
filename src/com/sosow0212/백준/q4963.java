package com.sosow0212.백준;

import java.util.Scanner;

public class q4963 {
    static int w, h;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dc = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dr = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            int count = 0;

            if (w == 0 && h == 0) {
                break;
            }

            graph = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= h || nc < 0 || nc >= w)
                continue;

            if (nr >= 0 && nc >= 0 && nr < h && nc < w) {
                if (graph[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
