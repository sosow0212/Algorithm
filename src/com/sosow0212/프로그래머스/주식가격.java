package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 주식가격 {
    static public List<Integer> solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < prices.length - 1; i++) {
            int temp = 0;
            for (int j = i + 1; j < prices.length; j++) {
                temp += 1;
                if(prices[j] < prices[i]) {
                    break;
                }
            }
            answer.add(temp);
        }
        answer.add(0);
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(solution(prices));
    }
}
