package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 배열두배만들기 {
    static public List<Integer> solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(i -> i * 2)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}));
    }
}
