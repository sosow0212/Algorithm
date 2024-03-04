package com.sosow0212.woowa_study.set2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q17141_2 {

    private static final int VIRUS_INDEX = 2;
    static int n;
    static int m;
    static int answer;
    static int[][] map;
    static List<int[]> virusPosition;
    static boolean[] virusVisited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = Integer.MAX_VALUE;
        map = new int[n][n];
        virusPosition = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 2) {
                    virusPosition.add(new int[]{i, j});
                    map[i][j] = 0;
                }
            }
        }

        virusVisited = new boolean[virusPosition.size()];
        permutation(0, new int[m][2]);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    static void permutation(int index, int[][] viruses) {
        if (index == m) {
            bfs(map.clone(), viruses);
            return;
        }

        for (int i = 0; i < virusPosition.size(); i++) {
            if (virusVisited[i]) {
                continue;
            }

            virusVisited[i] = true;
            viruses[index] = virusPosition.get(i);
            permutation(index + 1, viruses);
            virusVisited[i] = false;
        }
    }

    static void bfs(int[][] mapClone, int[][] viruses) {
        Queue<int[]> virusQueue = new ArrayDeque<>();
        int[][] dp = new int[n][n];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }

        for (int[] virus : viruses) {
            mapClone[virus[0]][virus[1]] = VIRUS_INDEX;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mapClone[i][j] == VIRUS_INDEX) {
                    virusQueue.add(new int[]{i, j});
                    dp[i][j] = 0;
                }
            }
        }

        boolean[][] visited = new boolean[n][n];
        boolean isDone = false;

        while (!virusQueue.isEmpty()) {
            if (isAllVirus(mapClone)) {
                isDone = true;
                break;
            }

            int[] virusPosition = virusQueue.poll();

            for (int[] position : pos) {
                int nr = position[0] + virusPosition[0];
                int nc = position[1] + virusPosition[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && mapClone[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    mapClone[nr][nc] = VIRUS_INDEX;
                    dp[nr][nc] = dp[virusPosition[0]][virusPosition[1]] + 1;
                    virusQueue.add(new int[]{nr, nc});
                }
            }
        }

        if (isDone) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    max = Math.max(dp[i][j], max);
                }
            }

            answer = Math.min(answer, max);
        }
    }

    private static boolean isAllVirus(final int[][] mapClone) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mapClone[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
