package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 특정문자제거하기 {
    static public String solution(String my_string, String letter) {
        return Arrays.stream(my_string.split(""))
                .filter(i -> !i.equals(letter))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdef", "f")); // abcde
    }
}
