package com.sosow0212.leetCode;

public class q713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 1;
        int answer = 0;

        while (right < nums.length) {
            // 1. 오른쪽으로 가면서 곱한다
            sum *= nums[right];

            // 2. sum이 k 이상이라면 k 미만으로 가기 위해서 left를 올리고 나눠준다.
            while (sum >= k) {
                sum /= nums[left];
                left++;
            }

            // 3. 갯수 계산
            answer += (right - left) + 1;
            right++;
        }

        return answer;
    }
}
