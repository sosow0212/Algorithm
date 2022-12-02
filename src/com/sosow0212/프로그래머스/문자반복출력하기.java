package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 문자반복출력하기 {
    static public String solution(String my_string, int n) {
        String answer = "";

        answer = Arrays.stream(my_string.split(""))
                .map(i -> i.repeat(n))
                .collect(Collectors.joining());

        return answer;
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(solution(str, 3)); // hhheeellllllooo
    }
}
