package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q2589 {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private static int[][] distance;
    private static List<Integer> oneOfAnswer = new ArrayList<>();

    public static void main(String[] args) {
        initData();
        findAnswer();
        System.out.println(Collections.max(oneOfAnswer));
    }

    private static void initData() {
        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                    initNextStep();
                }
            }
        }
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (canUseBfs(nr, nc)) {
                    visited[nr][nc] = true;
                    distance[nr][nc] = distance[now[0]][now[1]] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        addMaxDistance(distance);
    }

    private static boolean canUseBfs(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == 'L';
    }

    private static void addMaxDistance(int[][] mapOfDistance) {
        int maxValueOfDistance = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxValueOfDistance = Math.max(maxValueOfDistance, mapOfDistance[i][j]);
            }
        }
        oneOfAnswer.add(maxValueOfDistance);
    }

    private static void initNextStep() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
            Arrays.fill(distance[i], 0);
        }
    }
}
