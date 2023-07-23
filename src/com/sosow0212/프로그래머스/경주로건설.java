package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 경주로건설 {

    static int n, m;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int answer;

    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        m = board[0].length;
        bfs(board);
        return answer;
    }

    private static void bfs(final int[][] board) {
        boolean[][] visited = new boolean[n][m];
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(List.of(0, 0, -1)));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            List<Integer> now = q.poll();
            int row = now.get(0);
            int col = now.get(1);
            int direction = now.get(2);

            if (row == n - 1 && col == m - 1) {
                answer = Math.min(answer, board[row][col]);
            }

            for (int i = 0; i < pos.length; i++) {
                int nr = now.get(0) + pos[i][0];
                int nc = now.get(1) + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] != 1)) {
                    continue;
                }

                int nextCost = 0;
                if (direction == i || direction == -1) {
                    nextCost = board[row][col] + 100;
                } else {
                    nextCost = board[row][col] + 600;
                }

                if (!visited[nr][nc] || board[nr][nc] >= nextCost) {
                    board[nr][nc] = nextCost;
                    visited[nr][nc] = true;
                    q.add(new ArrayList<>(List.of(nr, nc, i)));
                }
            }
        }
    }

    public static void main(String[] args) {
        경주로건설 sol = new 경주로건설();

        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        // 3800
        System.out.println(sol.solution(board));
    }
}
