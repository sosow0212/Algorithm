package com.sosow0212.woowa_study.set2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q17141 {

    private static int n, m;
    private static int[][] map;
    private static List<int[]> virus;
    private static int[][] startPos;
    private static int[][] test;
    private static int min;
    private static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][n];
        virus = new ArrayList<>();
        min = Integer.MAX_VALUE;
        startPos = new int[m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        permutation(0, 0);
    }

    private static void permutation(final int index, final int start) {
        if (index == m) {
            bfs();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            startPos[index] = virus.get(i);
            permutation(index + 1, start + 1);
        }
    }

    private static void bfs() {
        System.out.println(1);

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int[] virusPosition = startPos[i];
            visited[virusPosition[0]][virusPosition[1]] = true;
            q.add(virusPosition);
        }

        while (!q.isEmpty()) {

        }
    }
}
