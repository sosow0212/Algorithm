package com.sosow0212.프로그래머스다시;

import java.util.Stack;

public class 올바른괄호 {

    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        올바른괄호 sol = new 올바른괄호();

        System.out.println(sol.solution("()()")); // true
        System.out.println(sol.solution("(())()")); // true
        System.out.println(sol.solution(")()(")); // false;
    }
}
