package com.sosow0212.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DfsStudy {
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static List<Integer> answer = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) {
        initData();
        getAnswer();
        System.out.println(answer.size());
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    private static void getAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 1;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] == 1) {
                dfs(nr, nc);
                count++;
            }
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }
}
