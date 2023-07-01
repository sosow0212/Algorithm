package com.sosow0212.woowacourse_study.week1Test;

import java.util.Arrays;
import java.util.Scanner;

public class q17130_dp {

    static int n, m;
    static int answer;
    static char[][] map;
    static int[][] dp;
    static int[][] pos = {{-1, 1}, {0, 1}, {1, 1}};
    static int startRow, startCol;

    public static void main(String[] args) {
        initData();
        bfs();
        getAnswer();
    }

    private static void getAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'O')
                    answer = Math.max(dp[i][j], answer);
            }
        }

        System.out.println(answer);
    }

    public static void bfs() {
        dp[startRow][startCol] = 0;

        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                if (map[row][col] == '#') {
                    continue;
                }

                for (int i = 0; i < 3; i++) {
                    int beforeRow = row - pos[i][0];
                    int beforeCol = col - pos[i][1];

                    if (!isValidRangeOfMap(beforeRow, beforeCol)) {
                        continue;
                    }

                    if (dp[beforeRow][beforeCol] == -1) {
                        continue;
                    }

                    if (map[row][col] == 'C') {
                        dp[row][col] = Math.max(dp[row][col], dp[beforeRow][beforeCol] + 1);
                    } else {
                        dp[row][col] = Math.max(dp[row][col], dp[beforeRow][beforeCol]);
                    }
                }
            }
        }
    }

    public static boolean isValidRangeOfMap(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = -1;
        map = new char[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        map[startRow][startCol] = '.';
        dp[startRow][startCol] = 0;
    }
}
