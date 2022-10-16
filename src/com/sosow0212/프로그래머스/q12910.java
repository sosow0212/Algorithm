package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q12910 {
    static public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(arr);
        for(int i : arr) {
            if(i % divisor == 0) {
                answer.add(i);
            }
        }

        if(answer.size() == 0) {
            answer.add(-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        System.out.println(solution(arr, divisor));

    }
}
