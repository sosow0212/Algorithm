package com.sosow0212.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        Map<Integer, Integer> valOfIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valOfIndex.put(nums[i], i);
        }

        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while (true) {
            int sum = nums[l] + nums[r];

            if (sum == target) {
                answer[0] = valOfIndex.get(nums[l]);
                answer[1] = valOfIndex.get(nums[r]);
                break;
            }

            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return answer;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        return answer;
    }

}
