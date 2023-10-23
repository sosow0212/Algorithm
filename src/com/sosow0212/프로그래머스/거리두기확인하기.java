package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 거리두기확인하기 {

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int t = 0; t < places.length; t++) {
            char[][] map = new char[5][5];

            for (int i = 0; i < 5; i++) {
                map[i] = places[t][i].toCharArray();
            }

            boolean isCorrect = false;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == 'P') {
                        if (isExistPeople(i, j, map)) {
                            isCorrect = true;
                            break;
                        }
                    }
                }
                if (isCorrect) {
                    answer[t] = 0;
                }
            }
            if (!isCorrect) {
                answer[t] = 1;
            }
        }

        return answer;
    }

    static boolean isExistPeople(int i, int j, char[][] map) {
        int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int idx = 0; idx < pos.length; idx++) {
            int[] dir = pos[idx];
            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
                continue;
            }

            if (map[nr][nc] == 'P') {
                return true;
            }
        }

        pos = new int[][]{{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
        for (int idx = 0; idx < pos.length; idx++) {
            int[] dir = pos[idx];
            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
                continue;
            }

            if (map[nr][nc] == 'P') {
                if (map[(i + nr) / 2][(j + nc) / 2] != 'X') {
                    return true;
                }
            }
        }

        pos = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int idx = 0; idx < pos.length; idx++) {
            int[] dir = pos[idx];
            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
                continue;
            }

            if (map[nr][nc] == 'P' && !(map[i][nc] == 'X' && map[nr][j] == 'X')) {
                return true;
            }
        }

        pos = new int[][]{{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
        for (int idx = 0; idx < pos.length; idx++) {
            int[] dir = pos[idx];
            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
                continue;
            }

            if (map[nr][nc] == 'P') {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        // [1, 0, 1, 1, 1]
        System.out.println(Arrays.toString(solution(places)));
    }
}
