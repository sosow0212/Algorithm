package com.sosow0212.프로그래머스다시;

public class 가장큰정사각형찾기 {

    public static int solution(int[][] board) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        };

        // 9
        System.out.println(solution(board));
    }
}
