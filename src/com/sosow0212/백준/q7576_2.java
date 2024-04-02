package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q7576_2 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Tomato {
        int row;
        int col;
        int value;

        public Tomato(final int row, final int col, final int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        answer = 0;
        map = new int[n][m];
        visited = new boolean[n][m];
        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    q.add(new Tomato(i, j, 0));
                }
            }
        }

        if (checkAllTomato(map)) {
            System.out.println(0);
            return;
        }

        /**
         * 3 1 0 0 0
         * 0 3 3 3 0
         * 0 3 3 3 0
         * 0 3 3 3 0
         * 0 0 0 0 0
         */

        int day = 0;
        while (!q.isEmpty()) {
            Tomato now = q.poll();
            day = now.value;

            for (int i = 0; i < pos.length; i++) {
                int nr = now.row + pos[i][0];
                int nc = now.col + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc])) {
                    continue;
                }

                if (map[nr][nc] != 0) {
                    continue;
                }

                map[nr][nc] = 1;
                q.add(new Tomato(nr, nc, day + 1));
            }
        }

        if (!checkAllTomato(map)) {
            System.out.println(-1);
            return;
        }

        System.out.println(day);
    }

    static boolean checkAllTomato(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
