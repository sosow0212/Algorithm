package com.sosow0212.프로그래머스다시;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격_stack {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{prices[prices.length - 1], 0});

        for (int i = prices.length - 2; i >= 0; i--) {
            int price = prices[i];
            int popCount = 1;

            while (!stack.isEmpty() && price <= stack.peek()[0]) {
                int[] before = stack.pop();
                popCount += before[1];
            }
            stack.push(new int[]{price, popCount});
            answer[i] = popCount;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 4 3 1 1 0
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }
}
