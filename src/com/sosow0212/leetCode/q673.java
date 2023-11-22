package com.sosow0212.leetCode;

import java.util.Arrays;

public class q673 {

    // retry 1129

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int answer = 0;

        dp[0] = 1;
        int beforeMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int nowNum = nums[i];

            if (nowNum > beforeMax) {
                beforeMax = nowNum;
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        int dpMaxVal = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            dpMaxVal = Math.max(dpMaxVal, dp[i]);
        }


        if (dpMaxVal == 1) {
            answer = dp.length;
        } else if (dp[dp.length - 1] == dpMaxVal) {
            for (int j : dp) {
                if (j == dpMaxVal - 1) {
                    answer++;
                }
            }
        } else {
            for (int j : dp) {
                if (j == dpMaxVal - 1) {
                    answer++;
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return answer;
    }

    public static void main(String[] args) {
        q673 sol = new q673();

        int[] nums = {1, 3, 5, 4, 7};
//        System.out.println(sol.findNumberOfLIS(nums)); // 2

        int[] nums1 = {2, 2, 2, 2, 2};
//        System.out.println(sol.findNumberOfLIS(nums1)); // 5

        int[] nums2 = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(sol.findNumberOfLIS(nums2)); // 3
    }
}
