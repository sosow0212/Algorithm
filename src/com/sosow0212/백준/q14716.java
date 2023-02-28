package com.sosow0212.백준;

import java.util.Scanner;

public class q14716 {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer = 0;
    private static int[][] pos = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    private static void getAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}
