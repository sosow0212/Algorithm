package com.sosow0212.leetCode;

public class q33 {

    public int search(int[] nums, int target) {
        int answer = -1;

        int rotationIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                rotationIndex = i;
                break;
            }
        }

        int left = 0;
        int right = rotationIndex - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        left = rotationIndex;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        q33 sol = new q33();

        // 4
        System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
