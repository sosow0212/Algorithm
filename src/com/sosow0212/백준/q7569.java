package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q7569 {

    static class Tomato {
        int h;
        int r;
        int c;

        public Tomato(final int h, final int r, final int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }

        public int getC() {
            return c;
        }

        public int getH() {
            return h;
        }

        public int getR() {
            return r;
        }
    }

    private static int m, n, h;
    private static int[][][] map;
    private static Queue<Tomato> queue = new LinkedList<>();
    private static int[] dx = {-1, 0, 1, 0, 0, 0};
    private static int[] dy = {0, 1, 0, -1, 0, 0};
    private static int[] dh = {0, 0, 0, 0, 1, -1};
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        map = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = sc.nextInt();
                    if (map[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k));
                    }
                }
            }
        }
    }

    private static void getAnswer() {
        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    answer = Math.max(answer, map[i][j][k]);
                }
            }
        }

        System.out.println(answer - 1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nh = tomato.getH() + dh[i];
                int nr = tomato.getR() + dy[i];
                int nc = tomato.getC() + dx[i];

                if (nh >= 0 && nh < h && nr >= 0 && nr < n && nc >= 0 && nc < m && map[nh][nr][nc] == 0) {
                    queue.add(new Tomato(nh, nr, nc));
                    map[nh][nr][nc] = map[tomato.getH()][tomato.getR()][tomato.getC()] + 1;
                }
            }
        }
    }

}
