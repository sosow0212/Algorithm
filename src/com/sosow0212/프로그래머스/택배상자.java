package com.sosow0212.프로그래머스;

import java.util.Stack;

public class 택배상자 {

    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[order.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            arr[i] = i;
        }

        int index = 1;
        for (int o : order) {

            if (o == arr[index]) {
                index++;
                answer++;
                continue;
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        택배상자 sol = new 택배상자();

        // 2
        int[] order = {4, 3, 1, 2, 5};
        System.out.println(sol.solution(order));

        // 5
        int[] order2 = {5, 4, 3, 2, 1};
        System.out.println(sol.solution(order2));
    }
}
