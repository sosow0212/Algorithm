package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 과일장수 {

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        List<Integer> scores = Arrays.stream(score)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        for (int i = 1; i <= scores.size(); i++) {
            if (i % m == 0) {
                answer += scores.get(i - 1) * m;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        // 33
        System.out.println(solution(k, m, score));
    }
}
