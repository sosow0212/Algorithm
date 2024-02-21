package com.sosow0212.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class q215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : nums) {
            pq.add(i);
        }

        while(true) {
            k--;
            int num = pq.poll();

            if(k == 0) {
                return num;
            }
        }
    }
}
