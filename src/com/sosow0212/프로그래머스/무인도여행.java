package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 무인도여행 {

    private static char[][] map;
    private static boolean[][] visited;
    private static List<Integer> answers;
    private static int count;
    private static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> solution(String[] maps) {
        initData(maps);
        getAnswer();

        return answers.size() == 0 ? List.of(-1) : answers;
    }

    private void initData(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        answers = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
    }

    private void getAnswer() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    answers.add(count);
                }
            }
        }

        Collections.sort(answers);
    }

    private void dfs(int row, int col) {
        visited[row][col] = true;
        count += map[row][col] - '0';

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !visited[nr][nc] && map[nr][nc] != 'X') {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) {
        무인도여행 sol = new 무인도여행();
        String[] map = {"X591X", "X1X5X", "X231X", "1XXX1"};
        String[] map2 = {"XXX", "XXX", "XXX"};
        System.out.println(sol.solution(map));
        System.out.println(sol.solution(map2));
    }
}
