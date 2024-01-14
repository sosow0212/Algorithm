package com.sosow0212.프로그래머스;

import java.util.Scanner;

public class q1189 {

    static int n;
    static int m;
    static int k;
    static char[][] map;
    static boolean[][] visited;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new char[n][m];
        visited = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }

        visited[n - 1][0] = true;
        dfs(n - 1, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int row, int col, int sum) {
        if (row == 0 && col == m - 1) {
            if (sum == k) {
                answer++;
            }

            return;
        }

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != 'T')) {
                continue;
            }

            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, sum + 1);
                visited[nr][nc] = false;
            }
        }
    }
}
