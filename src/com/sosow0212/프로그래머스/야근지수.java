package com.sosow0212.프로그래머스;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수 {

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int temp = 0;
        for (int work : works) {
            pq.add(work);
            temp += work;
        }

        if(temp < n) {
            return 0;
        }

        while (true) {
            if (n == 0) {
                break;
            }

            Integer poll = pq.poll();
            pq.add(poll - 1);
            n--;
        }

        while (!pq.isEmpty()) {
            int poll = pq.poll();
            answer += Math.pow(poll, 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};
        야근지수 sol = new 야근지수();

        // 12
        System.out.println(sol.solution(n, works));
    }
}
