package com.sosow0212.leetCode;

import java.util.Stack;

public class q121 {

    public int maxProfit(int[] prices) {
        int answer = 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            min = Math.min(price, min);

            if (price > min) {
                answer = Math.max(answer, price - min);
            }
        }

        return answer;
    }
}
