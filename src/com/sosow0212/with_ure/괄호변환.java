package com.sosow0212.with_ure;

import java.util.Stack;

public class 괄호변환 {

    private static final String CORRECT = "()";

    public static String solution(String p) {
        String answer = "";

        if (isCorrect(p)) {
            return p;
        }

        // "()))((()"
        /**
         */
        // ))((
        StringBuilder sb = new StringBuilder(p);
        while (!isCorrect(sb.toString())) {
            sb = new StringBuilder(sb.toString().replaceAll(CORRECT, ""));

        }

        return answer;
    }

    public static boolean isCorrect(final String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // "(()())()"
        System.out.println(solution("(()())()"));

        // "()"
        System.out.println(solution(")("));

        // "()(())()"
        System.out.println(solution("()))((()"));
    }
}
