package com.sosow0212.백준;

import java.util.Scanner;

public class q1937 {
    private final static Scanner sc = new Scanner(System.in);
    private static int n;
    private static int[][] map;
    private static int[][] mapOfEatingCount;
    private static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private static int answer = 0;

    public static void main(String[] args) {
        initData();
        findAnswer();
        System.out.println(answer);
    }

    private static void initData() {
        n = sc.nextInt();
        mapOfEatingCount = new int[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = dfs(i, j);
                answer = Math.max(answer, count);
            }
        }
    }

    private static int dfs(int row, int col) {
        if (mapOfEatingCount[row][col] != 0) {
            return mapOfEatingCount[row][col];
        }

        mapOfEatingCount[row][col] = 1;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] > map[row][col]) {
                mapOfEatingCount[row][col] = Math.max(mapOfEatingCount[row][col], dfs(nr, nc) + 1);
            }
        }
        return mapOfEatingCount[row][col];
    }
}
