package com.sosow0212.with_ure;

import java.util.Arrays;

public class 카펫 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;
        for (int i = 1; i <= total; i++) {
            int row = i;
            int col = total / row;

            if ((col - 2) * (row - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24, 24))); // 8 6
    }
}
