package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 파괴되지않은건물 {

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        int[][] sum = new int[n][m];

        for (int[] info : skill) {
            int type = info[0];
            int row = info[1];
            int col = info[2];
            int nr = info[3];
            int nc = info[4];
            int damage = info[5];

            if (type == 1) {
                for (int i = row; i <= nr; i++) {
                    for (int j = col; j <= nc; j++) {
                        sum[i][j] -= damage;
                    }
                }
            } else {
                for (int i = row; i <= nr; i++) {
                    for (int j = col; j <= nc; j++) {
                        sum[i][j] += damage;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                board[i][j] += sum[i][j];
                if (board[i][j] + sum[i][j] >= 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        // 10
        System.out.println(solution(board, skill));
    }
}
