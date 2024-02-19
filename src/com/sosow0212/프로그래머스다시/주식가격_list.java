package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.List;

public class 주식가격_list {

    public static List<Integer> solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < prices.length - 1; i++) {
            int now = prices[i];
            int count = 0;

            for (int j = i + 1; j < prices.length; j++) {
                int next = prices[j];
                count++;

                if (now > next) {
                    break;
                }
            }

            answer.add(count);
        }

        answer.add(0);

        return answer;
    }

    public static void main(String[] args) {
        // 4 3 1 1 0
        System.out.println(solution(new int[]{1, 2, 3, 2, 3}));
    }
}
