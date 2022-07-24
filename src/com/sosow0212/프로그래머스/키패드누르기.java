package com.sosow0212.프로그래머스;

import java.util.HashMap;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                left = num;
            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                right = num;
            } else {
                if (num == 0)
                    num = 11;

                int leftDist = Math.abs(num - left) / 3 + Math.abs(num - left) % 3;
                int rightDist = Math.abs(num - right) / 3 + Math.abs(num - right) % 3;

                if (leftDist < rightDist) {
                    answer += "L";
                    left = num;
                } else if (rightDist < leftDist) {
                    answer += "R";
                    right = num;
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = num;
                    } else {
                        answer += "R";
                        right = num;
                    }
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        키패드누르기 sol = new 키패드누르기();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(sol.solution(numbers, hand));
    }
}
