package com.sosow0212.프로그래머스;

import java.util.*;

public class 숫자짝꿍 {
    static public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int[] x = new int[10];
        int[] y = new int[10];
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < X.length(); i++) {
            int temp = X.charAt(i) - '0';
            x[temp]++;
        }
        for (int i = 0; i < Y.length(); i++) {
            int temp = Y.charAt(i) - '0';
            y[temp]++;
        }

        for (int i = 9; i >= 0; i--) {
            if (x[i] != 0 && y[i] != 0) {
                for (int j = 0; j < Math.min(x[i], y[i]); j++) list.add(i);
            }
        }

        if (list.size() == 0) {
            return "-1";
        } else if (list.get(0) == 0) {
            return "0";
        }

        for (int i : list) {
            answer.append(i);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String x = "100";
        String y = "123450";
        System.out.println(solution(x, y)); // 10
    }
}
