package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자짝꿍 {

    public static String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for (int i = 0; i < X.length(); i++) {
            int number = X.charAt(i) - '0';
            xArr[number]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            int number = Y.charAt(i) - '0';
            yArr[number]++;
        }

        List<Integer> pairNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (xArr[i] >= 1 && yArr[i] >= 1) {
                int count = Math.min(xArr[i], yArr[i]);

                for (int j = 0; j < count; j++) {
                    pairNumbers.add(i);
                }
            }
        }

        Collections.sort(pairNumbers, Collections.reverseOrder());
        StringBuilder answer = new StringBuilder();

        for (Integer pairNumber : pairNumbers) {
            answer.append(pairNumber);
        }

        if (answer.toString().isBlank()) {
            return "-1";
        }

        return String.valueOf(Integer.parseInt(answer.toString()));
    }

    public static void main(String[] args) {
        // -1
        System.out.println(solution("100", "2345"));

        // 100
        System.out.println(solution("100", "100"));

        // 321
        System.out.println(solution("12321", "42531"));
    }
}
