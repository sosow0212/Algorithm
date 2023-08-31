package com.sosow0212.toss.exam1.exam2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class q6 {

    public int solution(int[] prices, int k) {
        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < prices.length - k; i++) {
            int sum = 0;

            int price = prices[i];

            // 차이
            for (int j = i + 1; j < prices.length; j++) {
                pq.add(prices[j] - price);
            }

            for (int j = 0; j < k; j++) {
                sum += pq.poll();
            }

            answer = Math.max(sum, answer);
        }

        return answer == 0 ? -1 : answer;
    }


    public static void main(String[] args) {

    }
}
