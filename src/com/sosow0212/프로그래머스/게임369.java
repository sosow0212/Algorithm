package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 게임369 {
    static public int solution(int order) {
        return (int) Arrays.stream(String.valueOf(order).split(""))
                .filter(i -> Integer.valueOf(i) % 3 == 0)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(solution(29423)); // 2
    }
}
