package com.sosow0212.leetCode;

public class q456 {

    public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            min = Math.min(min, nums[i]);

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j] && min < nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        q456 sol = new q456();

        // true
        System.out.println(sol.find132pattern(new int[]{3, 1, 4, 2}));
    }
}
