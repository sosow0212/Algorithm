package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 문자열정렬하기 {
    static public List<Integer> solution(String my_string) {
        return Arrays.stream(my_string.split(""))
                .filter(i -> Character.isDigit(i.charAt(0)))
                .map(i -> Integer.parseInt(i))
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(solution("p2o4i8gj2")); // 2248
    }
}
