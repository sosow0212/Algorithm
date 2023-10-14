package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

    private static final int[] FIRST = {1, 2, 3, 4, 5};
    private static final int[] SECOND = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] THIRD = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};

    public static List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < answers.length; i++) {
            if (FIRST[i % 5] == answers[i]) {
                first++;
            }

            if (SECOND[i % 8] == answers[i]) {
                second++;
            }

            if (THIRD[i % 10] == answers[i]) {
                third++;
            }
        }

        int max = Integer.MIN_VALUE;
        max = Math.max(first, second);
        max = Math.max(max, third);

        if (first == max) {
            answer.add(1);
        }

        if (second == max) {
            answer.add(2);
        }

        if (third == max) {
            answer.add(3);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5})); // 1
        System.out.println(solution(new int[]{1, 3, 2, 4, 2})); // 1 2 3
    }
}
