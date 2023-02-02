package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q1725 {
    public static void main(String[] args) {
        // 1. 데이터 셋업
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = Integer.MIN_VALUE;
        int weight = 0;
        Stack<int[]> stack = new Stack<>();

        // 2. 순회
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            weight = 0;
            while (!stack.empty() && input < stack.peek()[0]) {
                weight += stack.peek()[1];
                answer = Math.max(answer, weight * stack.peek()[0]);
                stack.pop();
            }
            weight++;
            stack.push(new int[]{input, weight});
        }

        // 3. 정답
        weight = 0;
        while (!stack.isEmpty()) {
            weight += stack.peek()[1];
            answer = Math.max(answer, weight * stack.peek()[0]);
            stack.pop();
        }

        System.out.println(answer);
    }
}
