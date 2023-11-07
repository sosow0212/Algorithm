package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q5427 {

    static final Scanner sc = new Scanner(System.in);
    static int n;
    static int m;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static char[][] map;
    static int[][] dp;
    static int[] startPos;
    static Queue<int[]> firePos;

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve() {
        m = sc.nextInt();
        n = sc.nextInt();
        map = new char[n][m];
        dp = new int[n][m];
        startPos = new int[2];
        firePos = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                map[i][j] = c;

                if (c == '@') {
                    startPos = new int[]{i, j};
                    dp[i][j] = 1;
                } else if (c == '*') {
                    firePos.add(new int[]{i, j});
                }
            }
        }

        bfs(startPos[0], startPos[1]);

        boolean impossible = true;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dp[i][0] != -1) {
                impossible = false;
                answer = Math.min(answer, dp[i][0]);
            }

            if (dp[i][m - 1] != -1) {
                impossible = false;
                answer = Math.min(answer, dp[i][m - 1]);
            }
        }

        for (int i = 0; i < m; i++) {
            if (dp[0][i] != -1) {
                impossible = false;
                answer = Math.min(answer, dp[0][i]);
            }

            if (dp[n - 1][i] != -1) {
                impossible = false;
                answer = Math.min(answer, dp[n - 1][i]);
            }
        }

        System.out.println(impossible ? "IMPOSSIBLE" : answer);
    }

    static void bfs(int row, int col) {
        boolean[][] visited = new boolean[n][m];
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            burn();

            for (int i = 0; i < q.size(); i++) {
                int[] now = q.poll();

                for (int j = 0; j < pos.length; j++) {
                    int nr = now[0] + pos[j][0];
                    int nc = now[1] + pos[j][1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m
                            && map[nr][nc] == '.' && !visited[nr][nc]) {
                        dp[nr][nc] = dp[now[0]][now[1]] + 1;
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    static void burn() {
        Queue<int[]> newQueue = new LinkedList<>();

        while (!firePos.isEmpty()) {
            int[] fire = firePos.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = fire[0] + pos[i][0];
                int nc = fire[1] + pos[i][1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == '.') {
                    map[nr][nc] = '*';
                    newQueue.add(new int[]{nr, nc});
                }
            }
        }

        firePos = new LinkedList<>(newQueue);
    }
}
