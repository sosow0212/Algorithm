package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q2504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == ')' && stack.peek() == '(') {

            }

            if (c == ']' && stack.peek() == '[') {

            }
        }
    }
}
