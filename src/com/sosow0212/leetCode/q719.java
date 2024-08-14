package com.sosow0212.leetCode;

import java.util.Arrays;

public class q719 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;

            int distance = getDistanceUnderValueOfMid(nums, mid);

            if (distance < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int getDistanceUnderValueOfMid(int[] nums, int mid) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }

            count += (right - left);
        }

        return count;
    }

    public static void main(String[] args) {
        q719 sol = new q719();
        System.out.println(sol.smallestDistancePair(new int[]{1, 6, 1}, 3));
    }
}
