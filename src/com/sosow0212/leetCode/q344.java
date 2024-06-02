package com.sosow0212.leetCode;

public class q344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            right--;
            left++;
        }
    }
}
