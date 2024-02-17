package com.sosow0212.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q1642 {

    static int n;
    static int m;
    static int[][] dp;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int solution(int[][] maps) {
        int answer = 0;

        n = maps.length;
        m = maps[0].length;
        dp = new int[n][m];
        visited = new boolean[n][m];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }

        dp[0][0] = 1;
        bfs(maps);

        return dp[n - 1][m - 1] == Integer.MIN_VALUE ? -1 : dp[n - 1][m - 1];
    }

    static void bfs(final int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && maps[nr][nc] == 1)) {
                    continue;
                }

                visited[nr][nc] = true;
                dp[nr][nc] = Math.max(dp[nr][nc], dp[now[0]][now[1]] + 1);
                q.add(new int[]{nr, nc});
            }
        }
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        System.out.println(solution(maps));
    }
}
