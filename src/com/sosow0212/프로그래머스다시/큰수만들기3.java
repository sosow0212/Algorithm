package com.sosow0212.프로그래머스다시;

import java.util.Stack;

public class 큰수만들기3 {

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            int now = number.charAt(i) - '0';

            if (stack.isEmpty()) {
                stack.push(now);
                continue;
            }

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

        for (int i = 0; i < stack.size(); i++) {
            answer.append(String.valueOf(stack.get(i)));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        // 94
        System.out.println(solution("1924", 2));
    }
}
