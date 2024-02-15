package com.sosow0212.leetCode;

import java.util.Arrays;

public class q2971 {

    public long largestPerimeter(int[] nums) {
        long[] arr = new long[nums.length];
        long answer = Integer.MIN_VALUE;

        Arrays.sort(nums);
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }

        for (int i = 2; i < nums.length; i++) {
            if (arr[i] - arr[i - 1] < arr[i - 1]) {
                answer = Math.max(answer, arr[i]);
            }
        }

        if (answer == Integer.MIN_VALUE) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        q2971 sol = new q2971();
        // 12
        System.out.println(sol.largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
    }
}
