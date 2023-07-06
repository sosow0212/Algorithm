package com.sosow0212.leetCode;

public class q209 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;

        int answer = Integer.MAX_VALUE;

        for (right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left++];
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void main(String[] args) {
        q209 sol = new q209();

        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        // 2
        System.out.println(sol.minSubArrayLen(target, nums));
    }
}
