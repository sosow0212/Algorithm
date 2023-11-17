package com.sosow0212.leetCode;

public class q1493 {

    // retry
    public int longestSubarray(int[] nums) {
        int answer = 0;

        int start = 0;
        int zero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }

            while (zero > 1) {
                if (nums[start] == 0) {
                    zero -= 1;
                }

                start++;
            }

            answer = Math.max(answer, i - start);
        }

        return answer;
    }

    public static void main(String[] args) {
        q1493 sol = new q1493();
        int[] nums = {1, 1, 0, 1};
        // 3
        System.out.println(sol.longestSubarray(nums));
    }
}
