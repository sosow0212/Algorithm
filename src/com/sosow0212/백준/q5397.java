package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q5397 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String str = sc.next();
            solve(str);
        }

    }

    static void solve(String str) {
        int index = 0;

        Stack<Character> pre = new Stack<>();
        Stack<Character> post = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isAlphabetic(c)) {
                pre.add(c);
            }

            if (c == '<' && !pre.isEmpty()) {
                post.add(pre.pop());
            }

            if (c == '>' && !post.isEmpty()) {
                pre.add(post.pop());
            }

            if (c == '-' && !pre.isEmpty()) {
                pre.pop();
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!post.isEmpty()) {
            pre.add(post.pop());
        }

        while (!pre.isEmpty()) {
            answer.append(pre.pop());
        }

        System.out.println(answer.reverse().toString());
    }
}
