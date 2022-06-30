package com.sosow0212.백준;

import java.util.Scanner;

public class q1388 {

    static int n, m;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        graph = new char[n][m];
        visited = new boolean[n][m];

        scan.nextLine();

        for (int i = 0; i < n; i++) {
            graph[i] = scan.nextLine().toCharArray();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j])
                    continue;
                int dir = graph[i][j] == '-' ? 0 : 1;
                result++;
                dfs(i, j, dir);
            }
        }

        System.out.println(result);

    }

    private static void dfs(int i, int j, int dir) {
        visited[i][j] = true;

        char need = dir == 0 ? '-' : '|';
        int newX = i + dr[dir];
        int newY = j + dc[dir];

        if (newX < 0 || newX >= n || newY < 0 || newY >= m)
            return;

        if (visited[newX][newY])
            return;

        if (graph[newX][newY] == need)
            dfs(newX, newY, dir);
    }

}