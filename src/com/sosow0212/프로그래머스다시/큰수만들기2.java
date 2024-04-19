package com.sosow0212.프로그래머스다시;

import java.util.Stack;

public class 큰수만들기2 {

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            int now = number.charAt(i) - '0';

            while (k >= 1 && !stack.isEmpty()) {
                if (stack.peek() < now) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }

            stack.push(now);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.reverse()
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("999", 1)); //
        System.out.println(solution("1231234", 3)); // 3234
        System.out.println(solution("4177252841", 4)); // 775841
    }
}
