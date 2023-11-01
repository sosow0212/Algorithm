package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class q1847_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        List<Integer> hit = new ArrayList<>();
        int hitIndex = 0;

        for (int i = 0; i < n; i++) {
            hit.add(sc.nextInt());
        }

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");

            while (!stack.isEmpty() && stack.peek().equals(hit.get(hitIndex))) {
                sb.append("-\n");
                stack.pop();
                hitIndex++;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }

        System.out.println(sb.toString());
    }
}
