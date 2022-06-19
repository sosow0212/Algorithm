package com.sosow0212.백준;

import java.util.Scanner;

public class q1303 {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int pos[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int temp = 0;
    static int countW = 0;
    static int countB = 0;

    static void dfsWhite(int x, int y) {
        visited[x][y] = true;
        temp ++;

        for (int i = 0; i < pos.length; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && graph[nx][ny] == 'W') {
                dfsWhite(nx, ny);
            }
        }
    }

    static void dfsBlue(int x, int y) {
        visited[x][y] = true;
        temp ++;

        for (int i = 0; i < pos.length; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && graph[nx][ny] == 'B') {
                dfsBlue(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        // white
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 'W') {
                    dfsWhite(i, j);
                    countW += (int) Math.pow(temp, 2);
                    temp = 0;
                }
            }
        }

        // blue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 'B') {
                    dfsBlue(i, j);
                    countB += (int) Math.pow(temp, 2);
                    temp = 0;
                }
            }
        }

        System.out.println(countW + " " + countB);

    }
}
