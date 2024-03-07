package com.sosow0212.프로그래머스;

public class 파괴되지않은건물 {

    /**
     * 시간 초과!
     * 누적합으로 풀어야할듯
     */

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        int[][] prefix = new int[n][m];
        for (int[] s : skill) {
            if (s[0] == 1) {
                for (int j = s[1]; j <= s[3]; j++) {
                    for (int k = s[2]; k <= s[4]; k++) {
                        prefix[j][k] -= s[5];
                    }
                }
                continue;
            }

            if (s[0] == 2) {
                for (int j = s[1]; j <= s[3]; j++) {
                    for (int k = s[2]; k <= s[4]; k++) {
                        prefix[j][k] += s[5];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += prefix[i][j];

                if (board[i][j] > 0) {
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
