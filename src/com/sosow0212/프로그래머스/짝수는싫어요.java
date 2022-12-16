package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 짝수는싫어요 {
    static public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 1) {
                answer.add(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 10;

    }
}
