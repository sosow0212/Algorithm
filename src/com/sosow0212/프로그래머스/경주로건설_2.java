package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설_2 {

    static int[][] map;
    static boolean[][][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n;
    static int m;
    static int[][] dp;

    static class Node {
        int row;
        int col;
        int position;
        int price;

        public Node(final int row, final int col, final int position, final int price) {
            this.row = row;
            this.col = col;
            this.position = position;
            this.price = price;
        }
    }

    public static int solution(int[][] board) {
        int answer = 0;

        n = board.length;
        m = board[0].length;
        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m][4];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i = 0; i < board.length; i++) {
            map[i] = board[i];
        }

        bfs(0, 0);

        answer = dp[n - 1][m - 1];

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return answer;
    }

    static void bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col, -1, 100));
        visited[row][col][0] = true;
        dp[row][col] = 100;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now.row + pos[i][0];
                int nc = now.col + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0)) {
                    continue;
                }

                int cost = now.price;

                if (now.position == -1 || now.position == i) {
                    cost += 100;
                } else {
                    cost += 600;
                }

                if (!visited[nr][nc][i] && dp[nr][nc] >= cost) {
                    q.add(new Node(nr, nc, i, cost));
                    dp[nr][nc] = cost;
                    visited[nr][nc][i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        // 900
        System.out.println(solution(board));


        int[][] board2 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};

        // 3800
        System.out.println(solution(board2));

    }
}
