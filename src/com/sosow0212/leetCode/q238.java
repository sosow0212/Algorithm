package com.sosow0212.leetCode;

import java.util.Arrays;

public class q238 {

    public static int[] productExceptSelf(int[] nums) {
        /**
         * 누적합을 배열의 왼쪽부터 오른쪽까지 해준 후
         * 누적합을 오른쪽부터 왼쪽까지 다시 해주면 자기 자신을 제외한 모든 원소의 곱을 가진다
         */
        int[] answer = new int[nums.length];
        int n = answer.length;

        Arrays.fill(answer, 1);

        int now = 1;
        for (int i = 0; i < n; i++) {
            answer[i] *= now;
            now *= nums[i];
        }

        now = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= now;
            now *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        // 0 0 -9 0 0
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, -1, 0, -3, 3})));

    }
}
