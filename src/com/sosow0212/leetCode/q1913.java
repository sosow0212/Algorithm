package com.sosow0212.leetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class q1913 {

    public int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums) {
            min.add(num);
            max.add(num);
        }

        int maxVal = max.poll() * max.poll();
        int minVal = min.poll() * min.poll();

        return maxVal - minVal;

    }
}
