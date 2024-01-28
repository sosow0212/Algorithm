package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q4889 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str;
        StringBuilder answer = new StringBuilder();

        int test = 0;
        while (true) {
            test++;
            str = sc.next();
            int count = 0;
            Stack<Character> stack = new Stack<>();

            if (str.contains("-")) {
                break;
            }

            for (char c : str.toCharArray()) {
                if (c == '{') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty()) {
                        count++;
                        stack.add('{');
                        continue;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                count += stack.size() / 2;
            }
            answer.append(test + ". " + count).append("\n");
        }

        System.out.println(answer.toString());
    }
}
