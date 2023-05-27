package com.sosow0212.백준;

import java.util.Scanner;

public class q16234_2 {

    static int n, l, r;
    static int[][] map;
    static int answer;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        answer = 0;

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    private static void getAnswer() {
        dfs(l, r);
        System.out.println(answer);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];
        }
    }
}
