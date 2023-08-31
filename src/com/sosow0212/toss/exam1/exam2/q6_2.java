package com.sosow0212.toss.exam1.exam2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class q6_2 {

    public int solution(int[] prices, int k) {
        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < prices.length - k; i++) {
            int sum = 0;

            for (int j = i + 1; j < prices.length; j++) {
                pq.add(prices[j] - prices[i]);
            }

            for (int j = 0; j < k; j++) {
                sum += pq.poll();
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }


    public static void main(String[] args) {
        q6_2 sol = new q6_2();

        int[] prices = {10, 7, 8, 5, 8, 7, 6, 2, 9};
        int k = 3;

        // 9
        System.out.println(sol.solution(prices, k));
    }
}
