package com.sosow0212.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇 {

    static int n, m;
    static int[][] dp;
    static char[][] map;
    static int answer;
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] start;
    static int[] destination;
    static boolean[][] visited;

    public int solution(String[] board) {
        initData(board);
        bfs(start[0], start[1]);
        answer = dp[destination[0]][destination[1]];
        return answer == 0 ? -1 : answer;
    }

    private void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == destination[0] && now[1] == destination[1]) {
                answer = dp[now[0]][now[1]];
                return;
            }

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0];
                int nc = now[1];

                while (isValidRange(nr, nc) && map[nr][nc] != 'D') {
                    nr += pos[i][0];
                    nc += pos[i][1];
                }

                nr -= pos[i][0];
                nc -= pos[i][1];

                if (visited[nr][nc] || (now[0] == nr && now[1] == nc)) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
                dp[nr][nc] = dp[now[0]][now[1]] + 1;
            }
        }
    }

    private boolean isValidRange(final int nr, final int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }

    private void initData(final String[] board) {
        n = board.length;
        m = board[0].length();
        answer = 0;
        dp = new int[n][m];
        map = new char[n][m];
        start = new int[2];
        destination = new int[2];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String b = board[i];
            map[i] = b.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }

                if (map[i][j] == 'G') {
                    destination[0] = i;
                    destination[1] = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        리코쳇 sol = new 리코쳇();

        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(sol.solution(board)); // 7

        String[] board2 = {".D.R", "....", ".G..", "...D"};
        System.out.println(sol.solution(board2)); // -1
    }
}
