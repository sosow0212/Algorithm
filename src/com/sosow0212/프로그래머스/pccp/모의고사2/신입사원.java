package com.sosow0212.프로그래머스.pccp.모의고사2;

import java.util.PriorityQueue;

public class 신입사원 {

    public int solution(int[] ability, int number) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : ability) {
            pq.add(i);
        }

        while (number-- > 0) {
            Integer first = pq.poll();
            Integer second = pq.poll();
            int next = first + second;
            pq.add(next);
            pq.add(next);
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        신입사원 sol = new 신입사원();

        // 37
        System.out.println(sol.solution(new int[]{10, 3, 7, 2}, 2));
    }
}
