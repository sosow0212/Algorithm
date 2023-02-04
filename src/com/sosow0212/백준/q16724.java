package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class q16724 {
    private static int n, m;
    private static char[][] map;
    private static boolean[][] visited;
    private static HashMap<Character, int[]> pos = new HashMap<>();
    private static int answer = 0;

    public static void main(String[] args) {
        initData();
        fillingHash();
        findAnswer();
        System.out.println(answer);
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
    }

    private static void fillingHash() {
        pos.put('D', new int[]{1, 0});
        pos.put('U', new int[]{-1, 0});
        pos.put('R', new int[]{0, 1});
        pos.put('L', new int[]{0, -1});
    }

    private static void findAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
    }

    private static void dfs(int row, int col) {
        if (!visited[row][col] && row >= 0 && row < n && col >= 0 && col < m) {
            visited[row][col] = true;
            int[] nextPos = pos.get(map[row][col]);
            int nr = row + nextPos[0];
            int nc = col + nextPos[1];
            dfs(nr, nc);
        }
    }
}
