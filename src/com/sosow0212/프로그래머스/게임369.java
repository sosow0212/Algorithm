package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 게임369 {
    static public int solution(int order) {
        return (int) Arrays.stream(String.valueOf(order).split(""))
                .filter("369"::contains)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(solution(356)); // 2
    }
}
