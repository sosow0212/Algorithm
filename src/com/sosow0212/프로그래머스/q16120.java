package com.sosow0212.프로그래머스;

import java.util.Scanner;
import java.util.Stack;

public class q16120 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'P') {
                stack.push('P');
            } else {
                // A
                if (stack.size() >= 2 && i != str.length() - 1 && str.charAt(i + 1) == 'P') {
                    stack.pop();
                    stack.pop();
                } else {
                    System.out.println("NP");
                    return;
                }
            }
        }

        if (stack.size() == 1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
