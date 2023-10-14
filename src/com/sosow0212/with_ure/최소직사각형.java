package com.sosow0212.with_ure;

import java.util.Arrays;

public class 최소직사각형 {

    public static int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];

            int a = size[0];
            int b = size[1];

            if (b > a) {
                sizes[i] = new int[]{b, a};
            }
        }

        int row = Integer.MIN_VALUE;
        int col = Integer.MIN_VALUE;

        for (int i = 0; i < sizes.length; i++) {
            row = Math.max(row, sizes[i][0]);
            col = Math.max(col, sizes[i][1]);
        }

        return row * col;
    }

    public static void main(String[] args) {
        int[][] sizes = {
                {14, 4},
                {19, 6},
                {6, 16},
                {18, 7},
                {7, 11}
        }; // 19 * 7

        System.out.println(solution(sizes)); // 133
    }
}
