package com.sosow0212.프로그래머스다시;

import java.util.Arrays;

public class 카펫2 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        int tileCount = brown + yellow;

        for (int i = 1; i <= tileCount; i++) {
            int col = tileCount / i;

            if ((i - 2) * (col - 2) == yellow) {
                return new int[]{col, i};
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 4, 3
        System.out.println(Arrays.toString(solution(10, 2)));

        // 8, 6
//        System.out.println(Arrays.toString(solution(24, 24)));
    }
}
