package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class q2493_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<int[]> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            map.put(height, i + 1);

            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= height) {
                    answer.add(stack.peek()[0]);
                    break;
                }

                stack.pop();
            }

            if (stack.isEmpty()) {
                answer.add(0);
            }

            stack.push(new int[]{i + 1, height});
        }

        System.out.println(answer);
    }
}
