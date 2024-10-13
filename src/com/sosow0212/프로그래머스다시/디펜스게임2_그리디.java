package com.sosow0212.프로그래머스다시;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디펜스게임2_그리디 {

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            int task = enemy[i];
            pq.add(task);

            n -= task;
            while (n < 0 && k > 0 && !pq.isEmpty()) {
                k--;
                n += pq.poll();
            }

            if (n < 0) {
                break;
            }

            answer++;
        }

        return answer;
    }
}
