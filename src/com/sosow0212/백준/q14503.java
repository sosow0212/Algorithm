package com.sosow0212.백준;

import java.util.Scanner;

public class q14503 {

    private static final int NO_CLEAN = 0;
    private static final int WALL = 1;
    private static final int CLEAN = 10;

    static int n;
    static int m;
    static int[][] map;
    static int[] startPos;
    static int startDir;
    static int answer = 0;
    static int[][] pos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        startPos = new int[2];
        answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        startPos[0] = sc.nextInt();
        startPos[1] = sc.nextInt();
        startDir = sc.nextInt();

        dfs(startPos[0], startPos[1], startDir);
        System.out.println(answer);
    }

    static void dfs(int row, int col, int dir) {
        map[row][col] = CLEAN;

        for (int i = 0; i < pos.length; i++) {
            dir -= 1;

            if (dir == -1) {
                dir = 3;
            }

            int nx = row + pos[dir][0];
            int ny = col + pos[dir][1];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && (map[nx][ny] == 0)) {
                answer++;
                dfs(nx, ny, dir);
                return;
            }
        }

        int backDir = (dir + 2) % 4;
        int nr = row + pos[backDir][0];
        int nc = col + pos[backDir][1];

        if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] != 1) {
            dfs(nr, nc, dir);
        }
    }
}
