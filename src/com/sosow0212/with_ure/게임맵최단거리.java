package com.sosow0212.with_ure;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static int[][] dp;
    static int r;
    static int c;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int solution(int[][] maps) {
        int answer = 0;

        r = maps.length;
        c = maps[0].length;

        dp = new int[r][c];
        dp[0][0] = 1;

        bfs(0, 0, maps);

        return dp[r - 1][c - 1] == 0 ? -1 : dp[r - 1][c - 1];
    }

    static void bfs(int row, int col, int[][] maps) {
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc] && maps[nr][nc] != 0) {
                    dp[nr][nc] = dp[now[0]][now[1]] + 1;
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] map = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        System.out.println(solution(map)); // 11
    }
}
