package com.sosow0212.leetCode;

import java.util.Arrays;

public class q2962 {

    public static long countSubarrays(int[] nums, int k) {
        long answer = 0;

        int max = Arrays.stream(nums)
                .max()
                .getAsInt();

        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                maxCount++;
            }

            while (true) {
                if (k != maxCount) {
                    break;
                }

                if (nums[left] == max) {
                    maxCount--;
                }

                left++;
            }

            answer += left;
        }

        return answer;
    }
}
