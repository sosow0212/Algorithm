package com.sosow0212.woowacourse_study.week1Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17130_bfs_fail {

    static int[][] pos = {{0, 1}, {1, 1}, {-1, 1}};
    static int n, m;
    static char[][] map;
    static int[][] dp;
    static int[] start;
    static int answer;
    static Map<int[], Integer> exitCarrotSize;
    static boolean isFoundExit;

    public static void main(String[] args) throws IOException {
        initData();
        bfs();
        getAnswer();
    }

    private static void getAnswer() {
        for (int[] pos : exitCarrotSize.keySet()) {
            int row = pos[0];
            int col = pos[1];

            answer = Math.max(answer, dp[row][col]);
        }

        System.out.println(!isFoundExit ? -1 : answer);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!isValidRangeOfMap(nr, nc) || map[nr][nc] == '#') {
                    continue;
                }

                // 당근
                if (map[nr][nc] == 'C') {
                    dp[nr][nc] = Math.max(dp[nr][nc], dp[now[0]][now[1]] + 1);
                    q.add(new int[]{nr, nc});
                    continue;
                }

                // 빈 공간
                if (map[nr][nc] == '.') {
                    dp[nr][nc] = Math.max(dp[nr][nc], dp[now[0]][now[1]]);
                    q.add(new int[]{nr, nc});
                    continue;
                }

                // 출구
                if (map[nr][nc] == 'O') {
                    dp[nr][nc] = Math.max(dp[nr][nc], dp[now[0]][now[1]]);
                    q.add(new int[]{nr, nc});
                    isFoundExit = true;
                }

            }
        }
    }

    private static boolean isValidRangeOfMap(final int nr, final int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }

    private static void initData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        dp = new int[n][m];
        start = new int[2];
        answer = Integer.MIN_VALUE;
        exitCarrotSize = new HashMap<>();
        isFoundExit = false;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                map[i][j] = ch;
                if (ch == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'O') {
                    exitCarrotSize.put(new int[]{i, j}, 0);
                }
            }
        }
    }
}
