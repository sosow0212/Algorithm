package com.sosow0212.프로그래머스;

import java.util.Stack;

public class 짝지어제거하기 {

    public int solution(String s) {
        int answer = -1;
        char[] carr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < carr.length; i++) {
            char c = carr[i];

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        짝지어제거하기 sol = new 짝지어제거하기();

        String s = "baabaa"; // true 1
        System.out.println(sol.solution(s));

    }
}
