package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q10799 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && str.charAt(i - 1) == '(') {
                stack.pop();
                answer += stack.size();
            } else {
                stack.pop();
                answer++;
            }
        }

        System.out.println(answer);
    }
}
