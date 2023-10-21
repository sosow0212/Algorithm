package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.List;

public class 주식가격 {

    public static List<Integer> solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < prices.length - 1; i++) {
            int time = 0;

            for (int j = i + 1; j < prices.length; j++) {
                time ++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }

            answer.add(time);
        }

        answer.add(0);

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        // 4 3 1 1 0
        System.out.println(solution(prices));


        int[] test = {3, 4, 1, 3, 3, 2, 1};
        // 2 1 4 2 1 1 0
        System.out.println(solution(test));
    }
}
