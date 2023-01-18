package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q2573 {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] pos = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static int answer = 0;

    public static void main(String[] args) {
        // 1. 데이터 셋업
        initData();

        // 2. loop (빙산 세기, 빙산 녹이기)
        startLoop();

        // 3. 데이터 출력
        printAnswer();
    }

    private static void initData() {
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    private static void startLoop() {
        while (true) {
            // 1. 빙산의 조각 세기 (if. 빙산 0개, 혹은 분리시 return)
            int ice = countIce();
            if (ice == 0) {
                answer = 0;
                return;
            }
            if (ice >= 2) {
                return;
            }

            // 2. 빙산 녹이기
            bfsOfMeltingIce();
            answer++;
        }
    }

    private static int countIce() {
        visited = new boolean[n][m];
        int ice = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfsOfCountIce(i, j);
                    ice++;
                }
            }
        }
        return ice;
    }

    private static void dfsOfCountIce(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != 0 && !visited[nr][nc]) {
                dfsOfCountIce(nr, nc);
            }
        }
    }

    private static void bfsOfMeltingIce() {
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int blank = 0;

            for (int i = 0; i < pos.length; i++) {
                int nr = info[0] + pos[i][0];
                int nc = info[1] + pos[i][1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == 0) {
                    blank++;
                }
            }

            if (map[info[0]][info[1]] - blank < 0) {
                map[info[0]][info[1]] = 0;
            } else {
                map[info[0]][info[1]] -= blank;
            }
        }
    }

    private static void printAnswer() {
        System.out.println(answer);
    }
}
