package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 연속된부분수열 {

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length - 1};

        int left = 0;
        int right = 1;
        int sum = sequence[0];

        while (left < right) {
            if (sum == k) {
                if (right - 1 - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right - 1;
                }

                sum -= sequence[left];
                left++;
            } else if (sum > k) {
                sum -= sequence[left];
                left++;
            } else if (right < sequence.length) {
                sum += sequence[right];
                right++;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] seq = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;

        System.out.println(Arrays.toString(solution(seq, k)));
    }
}
