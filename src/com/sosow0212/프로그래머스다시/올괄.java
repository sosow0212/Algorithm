package com.sosow0212.프로그래머스다시;

import java.util.Stack;

public class 올괄 {

    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
