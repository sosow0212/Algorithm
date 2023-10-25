package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 이하로다른비트 {

    public static List<Long> solution(long[] numbers) {
        List<Long> answer = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];

            for (long j = number + 1; ; j++) {
                long diff = number ^ j;
                int bitCount = Long.bitCount(diff);

                if (bitCount <= 2) {
                    answer.add(j);
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 3 11
        System.out.println(solution(new long[]{2, 7}));
    }
}
