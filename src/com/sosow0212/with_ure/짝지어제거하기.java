package com.sosow0212.with_ure;

import java.util.Stack;

public class 짝지어제거하기 {

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == now) {
                stack.pop();
            } else {
                stack.push(now);
            }
        }

        return stack.isEmpty() ? 1: 0;
    }

    public static void main(String[] args) {
        // 1
        System.out.println(solution("baabaa"));

        // 0
        System.out.println(solution("cdcd"));
    }
}
