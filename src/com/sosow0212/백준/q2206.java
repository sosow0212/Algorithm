package com.sosow0212.백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q2206 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] visited;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[2][n][m];
        answer = Integer.MAX_VALUE;
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        // 1: true / 0:false
        // nr, nc, boolean, sum
        q.add(new int[]{0, 0, 0});
        dp[0][0] = 1;
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                answer = Math.min(answer, dp[n - 1][m - 1]);
                break;
            }

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && (!visited[0][nr][nc] || !visited[1][nr][nc]))) {
                    continue;
                }

                if (map[nr][nc] == 1 && !visited[1][nr][nc]) {
                    now[2] = 1;
                    q.add(new int[]{nr, nc, now[2]});
                    dp[nr][nc] = dp[now[0]][now[1]] + 1;
                    visited[1][nr][nc] = true;
                    continue;
                }

                if (map[nr][nc] == 1 && now[2] == 1) {
                    continue;
                }

                q.add(new int[]{nr, nc, now[2]});
                dp[nr][nc] = dp[now[0]][now[1]] + 1;
                visited[0][nr][nc] = true;
            }
        }
    }
}
