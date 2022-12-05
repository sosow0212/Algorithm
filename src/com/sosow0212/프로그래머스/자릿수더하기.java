package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 자릿수더하기 {
    static public int solution(int n) {
        return Arrays.stream(Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt).toArray()).sum();
    }

    public static void main(String[] args) {
        int n = 1234;
        System.out.println(solution(n)); // 10
    }
}
