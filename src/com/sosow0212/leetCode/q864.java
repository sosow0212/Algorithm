package com.sosow0212.leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class q864 {

    static int n, m;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] start;
    static Map<Character, Integer> keyMap;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int keyCount;
    static int answer;

    public int shortestPathAllKeys(String[] grid) {
        initData(grid);
        bfs(start[0], start[1]);
        return answer == 0 ? -1 : answer;
    }

    private static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] != '#')) {
                    continue;
                }

                if (map[nr][nc] == '.') {
                    dp[nr][nc] = Math.min(dp[nr][nc], dp[now[0]][now[1]] + 1);
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }

                if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
                    dp[nr][nc] = Math.min(dp[nr][nc], dp[now[0]][now[1]] + 1);
                    visited[nr][nc] = true;

                    if (keyMap.get(map[nr][nc]) == 0) {
                        keyCount++;
                        keyMap.put(map[nr][nc], 1);

//                        // 추가
//                        visited = new boolean[n][m];
                    }

                    if (keyCount == keyMap.size()) {
                        answer = dp[nr][nc];
                        System.out.println("answer : " + answer);
                        return;
                    }

                    q.add(new int[]{nr, nc});
                }

                if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F' && keyMap.get(Character.toLowerCase(map[nr][nc])) == 1) {
                    dp[nr][nc] = Math.min(dp[nr][nc], dp[now[0]][now[1]] + 1);
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static void initData(final String[] grid) {
        n = grid.length;
        m = grid[0].length();
        answer = 0;
        map = new char[n][m];
        start = new int[2];
        keyMap = new HashMap<>();
        visited = new boolean[n][m];
        keyCount = 0;
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = grid[i];
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                if (ch >= 'a' && ch <= 'f') {
                    keyMap.put(ch, 0);
                }

                map[i][j] = ch;
                if (map[i][j] == '@') {
                    start[0] = i;
                    start[1] = j;
                }

                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[start[0]][start[1]] = 0;
    }

    public static void main(String[] args) {
        q864 sol = new q864();

        // 8
        String[] grid = {"@.a..", "###.#", "b.A.B"};

        // 6
        String[] grid2 = {"@..aA", "..B#.", "....b"};

        // -1
        String[] grid3 = {"@Aa"};

        // 10
        String[] grid4 = {
                "@...a",
                ".###A",
                "b.BCc"};

        System.out.println(sol.shortestPathAllKeys(grid4));
    }
}
