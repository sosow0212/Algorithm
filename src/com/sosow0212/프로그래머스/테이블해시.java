package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 테이블해시 {

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }

            return o1[col - 1] - o2[col - 1];
        });

        for (int i = row_begin; i <= row_end; i++) {
            int[] tuple = data[i - 1];
            int sum = 0;

            for (int t : tuple) {
                sum += t % i;
            }

            answer ^= sum;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};

        // 4
        System.out.println(solution(data, 2, 2, 3));
    }
}
