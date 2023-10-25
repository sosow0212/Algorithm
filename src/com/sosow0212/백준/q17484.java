package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q17484 {

    static int n;
    static int m;
    static int[][] dp;
    static int[][] map;
    static int[][] pos = {{1, 0}, {1, -1}, {1, 1}};
    static final int INF = 1_000_000_000;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 6
        m = sc.nextInt(); // 4
        answer = INF;

        dp = new int[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) { // 컬럼, 각 컬럼마다 시작하는

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    dp[j][k] = INF;
                }
            }

            dp[0][i] = map[0][i];
            int minPoint = bfs(0, i);
            answer = Math.min(answer, minPoint);
        }


        System.out.println(answer);
    }

    static int bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col, -1});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                if (now[2] == i) {
                    continue;
                }

                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m)) {
                    continue;
                }

                dp[nr][nc] = Math.min(dp[nr][nc], dp[now[0]][now[1]] + map[nr][nc]);
                q.add(new int[]{nr, nc, i});
            }
        }

        int temp = INF;
        for (int i = 0; i < m; i++) {
            temp = Math.min(dp[n - 1][i], temp);
        }

        return temp;
    }
}
