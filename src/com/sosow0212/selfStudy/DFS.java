package com.sosow0212.selfStudy;

import java.util.*;

public class DFS {

    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n][n];

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        count++;

        for (int i = 0; i < pos.length; i++) {
            int nr = r + pos[i][0];
            int nc = c + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && graph[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}
