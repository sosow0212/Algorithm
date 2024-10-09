package com.sosow0212.leetCode;

import java.util.Stack;

public class q1963 {

    public int minSwaps(String s) {
        Stack<Character> stack = new Stack();

        int unPair = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    unPair++;
                }
            }
        }
        return (unPair + 1) / 2;
    }
}
