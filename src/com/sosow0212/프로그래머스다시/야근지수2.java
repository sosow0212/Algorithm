package com.sosow0212.프로그래머스다시;

import java.util.PriorityQueue;

public class 야근지수2 {

    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int work : works) {
            pq.add(work);
        }

        while (n-- > 0 && !pq.isEmpty()) {
            int now = pq.poll() - 1;

            if (now != 0) {
                pq.add(now);
            }
        }

        if (pq.isEmpty()) {
            return 0;
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            answer += Math.pow(poll, 2);
        }

        return answer;
    }
}
