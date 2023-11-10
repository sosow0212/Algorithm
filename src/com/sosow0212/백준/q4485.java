package com.sosow0212.백준;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q4485 {

    static final Scanner sc = new Scanner(System.in);

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int answer;

    static class Node implements Comparable<Node> {
        int start;
        int next;
        int weight;

        public Node(final int start, final int next, final int weight) {
            this.start = start;
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(final Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {

        int index = 1;
        while (true) {
            n = sc.nextInt();

            if (n == 0) {
                return;
            }

            solve(index);
            index++;
        }
    }

    static void solve(int problem) {
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        answer = 0;
        visited = new boolean[n][n];

        dp = new int[n][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        bfs(0, 0);
        System.out.println("Problem " + problem + ": " + answer);
    }

    static void bfs(int row, int col) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        visited[row][col] = true;

        q.add(new Node(0, 0, map[0][0]));
        dp[0][0] = map[0][0];

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now.start + pos[i][0];
                int nc = now.next + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                    continue;
                }

                if (now.weight + map[nr][nc] < dp[nr][nc]) {
                    dp[nr][nc] = now.weight + map[nr][nc];
                    q.add(new Node(nr, nc, dp[nr][nc]));
                }
            }
        }

        answer = dp[n - 1][n - 1];
    }
}
