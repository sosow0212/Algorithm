package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 무인도여행 {

    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<Integer> answer;

    public static int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    int count = bfs(i, j);
                    answer.add(count);
                }
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        return answer.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static int bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        visited[row][col] = true;
        q.add(new int[]{row, col});

        int count = map[row][col] - '0';

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] != 'X')) {
                    continue;
                }

                count += map[nr][nc] - '0';
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};

        // 1 1 27
        System.out.println(Arrays.toString(solution(maps)));
    }
}
