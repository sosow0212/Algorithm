package com.sosow0212.leetCode;

import java.util.Arrays;

public class q2656 {

    public int maximizeSum(int[] nums, int k) {
        int answer = 0;
        int index = 0;
        Arrays.sort(nums);

        while (index < k) {
            answer += nums[nums.length - 1];
            nums[nums.length - 1] += 1;
            index++;
        }

        return answer;
    }
}
