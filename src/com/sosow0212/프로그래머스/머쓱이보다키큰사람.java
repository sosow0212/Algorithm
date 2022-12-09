package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 머쓱이보다키큰사람 {
    static public int solution(int[] array, int height) {
        return (int) Arrays.stream(array)
                .filter(i -> i > height)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{149, 180, 192, 170}, 167)); // 3
    }
}
