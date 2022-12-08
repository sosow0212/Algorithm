package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 모음제거 {
    private final static List<String> vowels = List.of("a", "e", "i", "o", "u");

    static public String solution(String my_string) {
        return Arrays.stream(my_string.split(""))
                .filter(i -> !isVowels(i))
                .collect(Collectors.joining());
    }

    static boolean isVowels(String s) {
        if (vowels.contains(s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("nice to meet you")); // bs
    }
}
