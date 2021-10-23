package com.sosow0212.프로그래머스;

import java.util.Arrays;

class solution1 {
    public String solution(int[] numbers) {

        String[] stringNum = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stringNum[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(stringNum, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        String answer = "";

        if (stringNum[0].equals("0"))
            return "0";
        for (var number : stringNum) {
            answer += number;
        }

        return answer;
    }
}
