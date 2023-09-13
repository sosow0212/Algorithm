package com.sosow0212.프로그래머스;

import java.util.Stack;

public class 택배상자 {

    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subContainer = new Stack<>();

        int[] items = new int[order.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = i + 1;
        }

        int orderIndex = 0;
        int itemIndex = 0;

        while (itemIndex < order.length && orderIndex < order.length) {
            int orderItem = order[orderIndex];

            if (items[itemIndex] == orderItem) {
                // ## 현재 아이템과 찾는 게 같다면
                answer++;
                itemIndex++;
                orderIndex++;

                if (itemIndex == order.length) {
                    // 만약 마지막 아이템이 인덱스라면
                    while (!subContainer.isEmpty() && orderIndex < order.length) {
                        if (order[orderIndex] == subContainer.pop()) {
                            orderIndex++;
                            answer++;
                        }
                    }
                }
            } else {
                // 같지 않다면
                if (!subContainer.isEmpty() && subContainer.peek() == orderItem) {
                    // 1. 컨테이너가 비어있지 않고, peek()이 찾는 아이템인 경우
                    subContainer.pop();
                    orderIndex++;
                    answer++;
                } else if (!subContainer.isEmpty() && subContainer.peek() != orderItem) {
                    // 2. 컨테이너가 비어있지 않고, peek()이 찾는 아이템이 아닌 경우
                    subContainer.push(items[itemIndex]);
                    itemIndex++;
                } else {
                    // 3. 컨테이너가 비어있다면
                    subContainer.push(items[itemIndex]);
                    itemIndex++;
                }
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

        // 5
        int[] order3 = {3, 2, 1, 4, 5 };
        System.out.println(sol.solution(order3));
    }
}
