package com.sosow0212.leetCode;

import java.util.PriorityQueue;

public class q912 {

    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.add(i);
        }

        int[] answer = new int[nums.length];
        int index = 0;
        while (!pq.isEmpty()) {
            answer[index] = pq.poll();
            index++;
        }

        return answer;
    }
}
