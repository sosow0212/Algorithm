package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class qq17090 {

    private static int n, m;
    private static char[][] map;
    private static int[][] visited;
    private static int answer = 0;
    private static HashMap<Character, int[]> posMap = new HashMap<>();

    public static void main(String[] args) {
        initPos();
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }

        visited = new int[n][m];
    }

    private static void initPos() {
        posMap.put('D', new int[]{1, 0});
        posMap.put('U', new int[]{-1, 0});
        posMap.put('R', new int[]{0, 1});
        posMap.put('L', new int[]{0, -1});
    }

    private static void getAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 3) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    // 0:방문x, 1:방문, 2:방문,순회, 3:방문,순회x
    private static int dfs(int row, int col) {
        visited[row][col] = 1;

        int[] pos = posMap.get(map[row][col]);

        int nr = row + pos[0];
        int nc = col + pos[1];

        if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
            visited[row][col] = 3;
            return 3;
        }

        if (visited[nr][nc] == 0) {
            visited[row][col] = dfs(nr, nc);
        }

        if (visited[nr][nc] == 1) {
            visited[row][col] = 2;
            return 2;
        }

        if (visited[nr][nc] == 2) {
            visited[row][col] = 2;
            return 2;
        }

        visited[row][col] = 3;
        return 3;
    }
}
