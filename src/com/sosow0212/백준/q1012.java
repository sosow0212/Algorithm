package com.sosow0212.백준;

import java.util.Scanner;

public class q1012 {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m, k;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int answer = 0;

    public static void main(String[] args) {
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            getAnswer();
        }
    }

    private static void getAnswer() {
        initData();
        searchMap();
        System.out.println(answer);
    }

    private static void initData() {
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[m][n];
        visited = new boolean[m][n];
        k = sc.nextInt();
        answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 0;
            }
        }

        for (int i = 0; i < k; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            map[node2][node1] = 1;
        }
    }

    private static void searchMap() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(i, j);
                    answer++;
                }
            }
        }
    }

    private static void dfs(int row, int col) {
        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] == 1) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }
}
