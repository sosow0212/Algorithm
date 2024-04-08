package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q9935_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String boom = sc.next();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= boom.length()) {
                boolean isSame = true;

                for (int j = 0; j < boom.length(); j++) {
                    if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb = sb.reverse();

        if (sb.length() > 0) {
            System.out.println(sb.toString());
            return;
        }

        System.out.println("FRULA");
    }
}
