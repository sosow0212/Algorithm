package com.sosow0212.백준;

import java.util.Scanner;

public class q3187 {

    private static int n, m;
    private static int[][] pos = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static char[][] map;
    private static boolean visited[][];
    private static int k;
    private static int v;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void getAnswer() {
        int countOfK = 0;
        int countOfV = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    k = 0;
                    v = 0;

                    dfs(i, j);

                    if (v >= k) {
                        countOfV += v;
                    } else if (v < k) {
                        countOfK += k;
                    }
                }
            }
        }

        System.out.print(countOfK + " " + countOfV);
    }

    private static void dfs(final int row, final int col) {
        visited[row][col] = true;

        if (map[row][col] == 'k') {
            k++;
        } else if (map[row][col] == 'v') {
            v++;
        }

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] != '#') {
                dfs(nr, nc);
            }
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        k = 0;
        v = 0;

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
    }
}
