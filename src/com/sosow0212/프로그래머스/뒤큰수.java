package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.Stack;

public class 뒤큰수 {

    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty() || numbers[i] < numbers[i - 1]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    arr[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        뒤큰수 sol = new 뒤큰수();

        // 3,5,5,-1
        System.out.println(Arrays.toString(sol.solution(numbers)));
    }


}
