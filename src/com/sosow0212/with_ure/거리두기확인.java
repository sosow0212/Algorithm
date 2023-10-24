package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.List;

public class 거리두기확인 {

    public static List<Integer> solution(String[][] places) {
        List<Boolean> check = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (String[] place : places) {
            char[][] map = new char[5][5];

            for (int i = 0; i < place.length; i++) {
                map[i] = place[i].toCharArray();
            }

            boolean isSuccess = isSuccessCase(map);
            check.add(isSuccess);
        }

        for (Boolean b : check) {
            if (!b) {
                answer.add(0);
                continue;
            }

            answer.add(1);
        }

        return answer;
    }

    static boolean isSuccessCase(char[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    // 앞 뒤 1칸
                    int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                    for (int p = 0; p < pos.length; p++) {
                        int nr = i + pos[p][0];
                        int nc = j + pos[p][1];

                        if (!(nr >= 0 && nr < 5 && nc >= 0 && nc < 5)) {
                            continue;
                        }

                        if (map[nr][nc] == 'P') {
                            return false;
                        }
                    }

                    // 앞 뒤 2칸
                    int[][] pos2 = {{0, 2}, {0, -2}, {2, 0}, {-2, 0}};
                    for (int p = 0; p < pos2.length; p++) {
                        int nr = i + pos2[p][0];
                        int nc = j + pos2[p][1];

                        if (!(nr >= 0 && nr < 5 && nc >= 0 && nc < 5)) {
                            continue;
                        }

                        if (map[nr][nc] == 'P' && map[(i + nr) / 2][(j + nc) / 2] == 'O') {
                            return false;
                        }
                    }

                    // 대각선
                    int[][] pos3 = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
                    for (int p = 0; p < pos3.length; p++) {
                        int nr = i + pos3[p][0];
                        int nc = j + pos3[p][1];

                        if (!(nr >= 0 && nr < 5 && nc >= 0 && nc < 5)) {
                            continue;
                        }

                        if (map[nr][nc] == 'P' && (map[i][nc] == 'O' || map[nr][j] == ')')) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
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
        System.out.println(solution(places));
    }
}
