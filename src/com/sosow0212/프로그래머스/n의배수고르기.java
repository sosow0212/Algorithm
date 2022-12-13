package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class n의배수고르기 {
    static public List<Integer> solution(int n, int[] numlist) {
        return Arrays.stream(numlist)
                .boxed()
                .filter(i -> i % n == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})); // 6,9,12
    }
}
