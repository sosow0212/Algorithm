package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class 시추관bfs {

    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Map<Integer, Integer> oilOfCol;
    static boolean[][] visited;
    static int n;
    static int m;
    static int oil;
    static Set<Integer> colSet;

    public static int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;

        oilOfCol = new HashMap<>();
        visited = new boolean[n][m];
        colSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    oil = 0;
                    colSet = new HashSet<>();
                    dfs(i, j, land);

                    for (Integer col : colSet) {
                        oilOfCol.put(col, oilOfCol.getOrDefault(col, 0) + oil);
                    }
                }
            }
        }

        for (Integer value : oilOfCol.values()) {
            answer = Math.max(value, answer);
        }

        return answer;
    }

    static void dfs(int row, int col, int[][] land) {
        visited[row][col] = true;
        oil++;
        colSet.add(col);

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m
                    && !visited[nr][nc]
                    && land[nr][nc] == 1) {
                dfs(nr, nc, land);
            }
        }
    }

    public static void main(String[] args) {
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};

        // 9
        System.out.println(solution(land));
    }
}
