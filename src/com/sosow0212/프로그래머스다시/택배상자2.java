package com.sosow0212.프로그래머스다시;

import java.util.Stack;

public class 택배상자2 {

    public int solution(int[] order) {
        int[] priority = new int[order.length];

        for (int i = 0; i < order.length; i++) {
            priority[order[i] - 1] = i;
        }

        Stack<Integer> conveyor = new Stack<>();
        int index = 0;

        for (int i = 0; i < priority.length; i++) {
            if (priority[i] == index) {
                index++;
            } else {
                conveyor.push(priority[i]);
            }

            while (!conveyor.isEmpty() && conveyor.peek() == index) {
                conveyor.pop();
                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        택배상자2 sol = new 택배상자2();

        // 2
        System.out.println(sol.solution(
                new int[]{4, 3, 1, 2, 5}
        ));
    }
}
