package com.sosow0212.leetCode;

public class q9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String num = String.valueOf(x);
        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
