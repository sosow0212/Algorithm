package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 모음사전2 {

    private static String[] words = {"A", "E", "I", "O", "U"};
    private static List<String> list = new ArrayList<>();
    private static int answer = 0;

    public int solution(String word) {
        for (int i = 0; i < words.length; i++) {
            permutation(words[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    private void permutation(String word) {
        if (word.length() > 5) {
            return;
        }

        if (!list.contains(word)) {
            list.add(word);
        }

        for (int i = 0; i < words.length; i++) {
            permutation(word + words[i]);
        }
    }

    public static void main(String[] args) {
        모음사전2 sol = new 모음사전2();
        String word = "AAAAE";
        String word2 = "AAAE";
        System.out.println(sol.solution(word)); // 6
        System.out.println(sol.solution(word2)); // 10
    }
}
