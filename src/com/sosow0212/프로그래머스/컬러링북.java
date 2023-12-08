package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 컬러링북 {

    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int count;
    static Map<Long, Integer> pictureMap;
    static boolean[][] visited;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        count = 0;
        pictureMap = new HashMap<>();
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 0 && i < m && j >= 0 && j < n && picture[i][j] != 0 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j, m, n, picture[i][j], picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }

        int[] answer = {numberOfArea, maxSizeOfOneArea};
        System.out.println(Arrays.toString(answer));

        return answer;
    }

    static void dfs(int row, int col, int m, int n, long color, final int[][] picture) {
        visited[row][col] = true;
        pictureMap.put(color, pictureMap.getOrDefault(color, 0) + 1);
        count++;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && picture[nr][nc] == color) {
                dfs(nr, nc, m, n, color, picture);
            }
        }
    }

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        // 4 5
        System.out.println(solution(6, 4, picture));
    }
}
