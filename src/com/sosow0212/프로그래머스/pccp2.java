package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class pccp2 {

    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Map<Integer, Integer> map;
    static Set<Integer> cols;

    public static int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        map = new HashMap<>();
        cols = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    cols = new HashSet<>();
                    int oils = bfs(i, j, land);

                    for (Integer col : cols) {
                        map.put(col, map.getOrDefault(col, 0) + oils);
                    }
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer = Math.max(answer, entry.getValue());
        }

        return answer;
    }

    static int bfs(int row, int col, int[][] land) {
        visited[row][col] = true;
        cols.add(col);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        int oils = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && land[nr][nc] == 1)) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
                cols.add(nc);
                oils++;
            }
        }

        return oils;
    }

    public static void main(String[] args) {
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};

        // 9
        System.out.println(solution(land));
    }
}
