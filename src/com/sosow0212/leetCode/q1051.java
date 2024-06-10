package com.sosow0212.leetCode;

import java.util.Arrays;

public class q1051 {

    public int heightChecker(int[] heights) {
        int[] copy = new int[heights.length];

        for (int i = 0; i < copy.length; i++) {
            copy[i] = heights[i];
        }

        Arrays.sort(copy);

        int answer = 0;

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != heights[i]) {
                answer++;
            }
        }

        return answer;
    }
}
