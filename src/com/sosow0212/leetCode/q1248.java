package com.sosow0212.leetCode;

import java.util.HashMap;
import java.util.Map;

public class q1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        int subarrays = 0;
        int nowSum = 0;

        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(nowSum, 1);


        for (int num : nums) {
            nowSum += num % 2;

            if (prefixSum.containsKey(nowSum - k)) {
                subarrays += prefixSum.get(nowSum - k);
            }

            prefixSum.put(nowSum, prefixSum.getOrDefault(nowSum, 0) + 1);
        }

        return subarrays;
    }
}
