package com.sosow0212.selfStudy;

import java.util.*;

public class DFS {

    static int n;
    static int graph[][];
    static boolean visited[][];
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int count;

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
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void dfs(int r, int c) {
        count++;
        visited[r][c] = true;

        for (int i = 0; i < pos.length; i++) {
            // 상하좌우 탐색! 총 4번 실행
            int nr = r + pos[i][0];
            int nc = c + pos[i][1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && graph[nr][nc] == 1 && !visited[nr][nc]) {
                // 위에 조건이 맞으면 dfs
                dfs(nr, nc);
            }
        }
    }
}