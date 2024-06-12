package com.sosow0212.leetCode;

public class q75 {

    public void sortColors(int[] nums) {
        int[] arr = new int[3];

        for (int i : nums) {
            arr[i]++;
        }

        for (int i = 0; i < arr[0]; i++) {
            nums[i] = 0;
        }

        for (int i = 0; i < arr[1]; i++) {
            nums[i + arr[0]] = 1;
        }
        for (int i = 0; i < arr[2]; i++) {
            nums[i + arr[1] + arr[0]] = 2;
        }
    }
}
