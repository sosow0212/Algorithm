package com.sosow0212.프로그래머스;

public class qPccp9 {

    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        int n = board.length;

        String color = board[h][w];
        for (int i = 0; i < pos.length; i++) {
            int nr = h + pos[i][0];
            int nc = w + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && board[nr][nc].equals(color)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
