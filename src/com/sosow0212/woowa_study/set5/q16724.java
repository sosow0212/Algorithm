package com.sosow0212.woowa_study.set5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class q16724 {

    static int n;
    static int m;
    static char[][] map;
    static HashMap<Character, int[]> pos;
    static int answer;
    static int[][] visited;
    static int index;

    public static void main(String[] args) {
        init();
        getAnswer();
        System.out.println(answer);
    }

    private static void getAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, index);
                index++;
            }
        }
    }

    private static void dfs(int row, int col, int index) {
        if (visited[row][col] != -1) {
            if (visited[row][col] == index) {
                answer++;
            }

            return;
        }

        visited[row][col] = index;


        char next = map[row][col];
        int[] nextPos = pos.get(next);
        int nr = row + nextPos[0];
        int nc = col + nextPos[1];

        dfs(nr, nc, index);
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = 0;
        index = 0;

        map = new char[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }

        pos = new HashMap<>();
        pos.put('D', new int[]{1, 0});
        pos.put('U', new int[]{-1, 0});
        pos.put('R', new int[]{0, 1});
        pos.put('L', new int[]{0, -1});

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
    }
}
