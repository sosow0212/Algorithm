package com.sosow0212.leetCode;

public class q2396 {

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i < n - 1; i++) {
            if (!isPalindrome(n, i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome(final int n, final int parse) {
        String binary = Integer.toString(n, parse);
        int harfLength = binary.length() / 2;

        for (int i = 0; i < harfLength; i++) {
            char left = binary.charAt(i);
            char right = binary.charAt(binary.length() - (i + 1));

            if (left != right) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        q2396 sol = new q2396();
        System.out.println(sol.isStrictlyPalindromic(9));
    }
}
