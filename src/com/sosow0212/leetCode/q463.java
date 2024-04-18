package com.sosow0212.leetCode;

public class q463 {

    static int n;
    static int m;
    static int[][] map;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int answer;

    public static int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        map = new int[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                int nearIsland = 0;
                for (int p = 0; p < pos.length; p++) {
                    int nr = i + pos[p][0];
                    int nc = j + pos[p][1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 1) {
                        nearIsland++;
                    }
                }

                answer += (4 - nearIsland);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};

        // 16
        System.out.println(islandPerimeter(grid));
    }
}
