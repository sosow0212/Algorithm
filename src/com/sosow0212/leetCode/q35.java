package com.sosow0212.leetCode;

public class q35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
                answer = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        q35 sol = new q35();

        // 1
        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}
