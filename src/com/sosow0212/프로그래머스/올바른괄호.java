package com.sosow0212.프로그래머스;

import java.util.Stack;

public class 올바른괄호 {

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    stack.push(')');
                }
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            }
        }

        answer = stack.isEmpty() ? true : false;

        return answer;
    }

    public static void main(String[] args) {
        올바른괄호 sol = new 올바른괄호();
        System.out.println(sol.solution("()()")); // true
    }
}
