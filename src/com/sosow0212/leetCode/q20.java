package com.sosow0212.leetCode;

import java.util.Stack;

public class q20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // false
        System.out.println(isValid("(])"));
    }
}
