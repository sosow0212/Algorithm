package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 명예의전당1 {
    static public List<Integer> solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> scoreList = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            scoreList.add(score[i]);
            scoreList = scoreList.stream().sorted(Comparator.reverseOrder()).limit(k).collect(Collectors.toList());
            answer.add(scoreList.get(scoreList.size() - 1));
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(solution(k, score)); // [10, 10, 10, 20, 20, 100, 100]

        k = 4;
        score = new int[] {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println(solution(k, score)); // 0, 0, 0, 0, 20, 40, 70, 70, 150, 300
    }
}
