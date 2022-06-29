package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q7567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();

        String str = sc.next();
        int ans = 0;

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(i == 0) {
                ans += 10;
                stack.push(c);
                continue;
            }
            char temp = stack.peek();

            if(temp == c) {
                ans += 5;
            } else {
                ans += 10;
            }

            stack.push(c);
        }

        System.out.println(ans);
    }
}
