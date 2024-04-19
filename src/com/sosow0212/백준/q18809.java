package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q18809 {

    private static final int WATER = 0;
    private static final int EMPTY = -1;
    static int n;
    static int m;
    static int g;
    static int r;
    static int[][] map;
    static List<int[]> candidate;
    static int answer;
    static boolean[] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        g = sc.nextInt();
        r = sc.nextInt();
        candidate = new ArrayList<>();
        answer = 0;

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 2) {
                    candidate.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[candidate.size()];
        green(0, 0, new int[g][]);
        System.out.println(answer);
    }

    static void green(int index, int start, int[][] greenPos) {
        if (index == g) {
            red(0, 0, greenPos, new int[r][]);
            return;
        }

        for (int i = start; i < candidate.size(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            greenPos[index] = candidate.get(i);
            green(index + 1, i + 1, greenPos);
            visited[i] = false;
        }
    }

    static void red(int index, int start, int[][] greenPos, int[][] redPos) {
        if (index == r) {
            int count = calculate(greenPos, redPos);
            answer = Math.max(answer, count);
            return;
        }

        for (int i = start; i < candidate.size(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            redPos[index] = candidate.get(i);
            red(index + 1, i + 1, greenPos, redPos);
            visited[i] = false;
        }
    }

    static int calculate(int[][] greenPos, int[][] redPos) {
        int[][] copyMap = copy();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] != WATER) {
                    // 호수가 아니면
                    copyMap[i][j] = EMPTY;
                }
            }
        }

        int[][] greenDp = new int[n][m];
        Queue<int[]> greenQ = new LinkedList<>();
        Queue<int[]> redQ = new LinkedList<>();

        boolean[][] greenVisited = new boolean[n][m];
        boolean[][] redVisited = new boolean[n][m];

        for (int[] p : greenPos) {
            greenVisited[p[0]][p[1]] = true;
            greenQ.add(p);
        }

        for (int[] p : redPos) {
            redVisited[p[0]][p[1]] = true;
            redQ.add(p);
        }

        while (!greenQ.isEmpty()) {
            int[] now = greenQ.poll();

            for (int[] p : pos) {
                int nr = now[0] + p[0];
                int nc = now[1] + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !greenVisited[nr][nc] && map[nr][nc] != WATER) {
                    greenVisited[nr][nc] = true;
                    greenDp[nr][nc] = greenDp[now[0]][now[1]] + 1;
                    greenQ.add(new int[]{nr, nc});
                }
            }
        }

        int[][] redDp = new int[n][m];
        while (!redQ.isEmpty()) {
            int[] now = redQ.poll();

            for (int[] p : pos) {
                int nr = now[0] + p[0];
                int nc = now[1] + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !redVisited[nr][nc] && map[nr][nc] != WATER) {
                    redVisited[nr][nc] = true;
                    redDp[nr][nc] = redDp[now[0]][now[1]] + 1;
                    greenQ.add(new int[]{nr, nc});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (greenDp[i][j] == redDp[i][j] && greenDp[i][j] != 0) {
                    count++;
                }
            }
        }

        return count;
    }

    static int[][] copy() {
        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
            }
        }

        return copy;
    }
}
