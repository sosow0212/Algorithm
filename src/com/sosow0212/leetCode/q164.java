package com.sosow0212.leetCode;

import java.util.Arrays;

public class q164 {

    public int maximumGap(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int gap = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > gap) {
                gap = nums[i] - nums[i - 1];
            }
        }

        return gap;
    }
}
