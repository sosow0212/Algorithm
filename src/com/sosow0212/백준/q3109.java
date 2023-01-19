package com.sosow0212.백준;

import java.util.Scanner;

public class q3109 {
    private final static Scanner sc = new Scanner(System.in);
    private static int r, c;
    private static char[][] map;
    private static int[] pos = {-1, 0, 1};
    private static int answer = 0;

    public static void main(String[] args) {
        initData();
        findAnswer();
        System.out.println(answer);
    }

    private static void initData() {
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = sc.nextLine().toCharArray();
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < r; i++) {
            dfs(i, 0);
        }
    }

    public static boolean dfs(int row, int col) {
        if (col == c - 1) {
            answer++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nr = row + pos[i];
            int nc = col + 1;

            if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == '.') {
                map[nr][nc] = 'x';
                if (dfs(nr, nc)) {
                    return true;
                }
            }
        }

        return false;
    }
}
