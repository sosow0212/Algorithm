package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q3055 {
    private static final char WATER = '*';
    private static final char BIEBER = 'S';

    static char[][] map;
    static int r;
    static int c;
    static int sRow = 0;
    static int sCol = 0;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == BIEBER) {
                    sRow = i;
                    sCol = j;
                }
            }
        }
    }

    private static void getAnswer() {
        int result = bfs();
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sRow, sCol});

        int[][] dis = new int[r][c];
        dis[sRow][sCol] = 1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == WATER) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        queue.offer(new int[]{sRow, sCol});

        while (!queue.isEmpty()) {
            int[] move = queue.poll();
            char now = map[move[0]][move[1]];

            for (int i = 0; i < 4; i++) {
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (validation(moveY, moveX)) {
                    continue;
                }

                if (now == 'S') {
                    if (map[moveY][moveX] == 'D') {
                        return dis[move[0]][move[1]];
                    }
                    if (map[moveY][moveX] == '.') {
                        map[moveY][moveX] = 'S';
                        queue.offer(new int[]{moveY, moveX});
                        dis[moveY][moveX] = dis[move[0]][move[1]] + 1;
                    }
                }

                if (now == '*') {
                    if (map[moveY][moveX] == '.' || map[moveY][moveX] == 'S') {
                        map[moveY][moveX] = '*';
                        queue.offer(new int[]{moveY, moveX});
                    }
                }
            }
        }
        return -1;
    }

    private static boolean validation(int moveY, int moveX) {
        return !(0 <= moveY && moveY < r && 0 <= moveX && moveX < c);
    }
}
