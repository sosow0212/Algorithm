package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q2504 {

    static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int temp = 1;

        // ([])

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            if (now == '(') {
                stack.push(now);
                temp *= 2;
                continue;
            }

            if (now == '[') {
                stack.push(now);
                temp *= 3;
                continue;
            }

            if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }

                if (str.charAt(i - 1) == '(') {
                    answer += temp;
                }

                stack.pop();
                temp /= 2;
                continue;
            }

            if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }

                if (str.charAt(i - 1) == '[') {
                    answer += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
