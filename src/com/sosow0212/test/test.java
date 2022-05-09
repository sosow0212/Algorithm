package com.sosow0212.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {

    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int count = 0;
    static int[][] pos = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    arr.add(count);
                }
            }
        }

        System.out.println(arr.size());
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        count++;

        for (int i = 0; i < pos.length; i++) {
            int nr = r + pos[i][0];
            int nc = c + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && graph[nr][nc] == 1 & !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}
