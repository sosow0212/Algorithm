package com.sosow0212.프로그래머스다시;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수3 {

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }

        while (n-- > 0 && !pq.isEmpty()) {
            Integer now = pq.poll() - 1;

            if (now == 0) {
                continue;
            }

            pq.add(now);
        }

        while (!pq.isEmpty()) {
            answer += (long) Math.pow(pq.poll(), 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        야근지수3 sol = new 야근지수3();

        // 12
        System.out.println(sol.solution(4, new int[]{4, 3, 3}));

        // 3
        System.out.println(sol.solution(3, new int[]{1, 1}));
    }
}
