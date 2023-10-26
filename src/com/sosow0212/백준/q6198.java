package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class q6198 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int building = sc.nextInt();
            stack.push(building);
        }

        while (!stack.isEmpty()) {
            Integer building = stack.pop();

            if (list.isEmpty()) {
                list.add(building);
                answer.add(0);
                continue;
            }

            int count = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (building > list.get(i)) {
                    count++;
                } else {
                    break;
                }
            }

            answer.add(count);
            list.add(building);
        }

        int sum = 0;
        for (Integer i : answer) {
            sum += i;
        }

        System.out.println(sum);
    }
}
