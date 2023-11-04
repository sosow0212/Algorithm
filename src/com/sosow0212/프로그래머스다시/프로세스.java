package com.sosow0212.프로그래머스다시;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스 {

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : priorities) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 1
//        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));

        // 5
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
