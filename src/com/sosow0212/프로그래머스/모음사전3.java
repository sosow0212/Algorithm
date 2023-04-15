package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 모음사전3 {

    private static final String[] words = {"A", "E", "I", "O", "U"};
    private static List<String> dict;
    private static int answer;

    public int solution(String input) {
        answer = 0;
        dict = new ArrayList<>();

        for (String word : words) {
            permutation(word);
        }

        answer = dict.indexOf(input) + 1;
        return answer;
    }

    private void permutation(String combination) {
        if (combination.length() > 5) {
            return;
        }

        if (!dict.contains(combination)) {
            dict.add(combination);
        }

        for (int i = 0; i < words.length; i++) {
            permutation(combination + words[i]);
        }
    }

    public static void main(String[] args) {
        모음사전3 sol = new 모음사전3();

        System.out.println(sol.solution("AAAAE")); // 6
        System.out.println(sol.solution("AAAE")); // 10
        System.out.println(sol.solution("I")); // 1563
        System.out.println(sol.solution("EIO")); // 1189
    }
}
