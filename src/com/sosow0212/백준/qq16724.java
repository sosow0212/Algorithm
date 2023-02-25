package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class qq16724 {

    private static int n, m;
    private static HashMap<Character, int[]> posMap = new HashMap<>();
    private static char[][] map;
    private static int[][] visited;
    private static int answer = 0;

    public static void main(String[] args) {
        initPos();
        initData();
        getAnswer();
    }

    private static void initPos() {
        posMap.put('D', new int[]{1, 0});
        posMap.put('U', new int[]{-1, 0});
        posMap.put('R', new int[]{0, 1});
        posMap.put('L', new int[]{0, -1});
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
    }

    private static void getAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] == 0) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    // 0: 방문x, 1:방문중, 2:방문o,순회o
    private static int dfs(int row, int col) {
        visited[row][col] = 1;

        int[] pos = posMap.get(map[row][col]);

        int nr = row + pos[0];
        int nc = col + pos[1];

        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
            if (visited[nr][nc] == 0) {
                visited[row][col] = dfs(nr, nc);
            }

            if (visited[nr][nc] == 1) {
                visited[row][col] = 2;
                return 2;
            }

            if(visited[nr][nc] == 2) {
                visited[row][col] = 2;
                return 2;
            }
        }

        return 0;
    }
}
