package com.sosow0212.프로그래머스다시;

import java.util.PriorityQueue;

public class 더맵게2 {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }

        int mixCount = 0;
        boolean success = false;

        while (pq.size() >= 2) {
            Integer first = pq.poll();
            Integer second = pq.poll();

            if (first >= K) {
                success = true;
                break;
            }

            int now = first + second * 2;
            pq.add(now);
            mixCount++;
        }

        if (!pq.isEmpty()) {
            Integer last = pq.poll();
            if (last >= K) {
                success = true;
            }
        }

        return success ? mixCount : -1;
    }

    public static void main(String[] args) {
        더맵게2 sol = new 더맵게2();

        // 2
        System.out.println(sol.solution(
                new int[]{1, 2, 3, 9, 10, 12},
                7
        ));
    }
}
