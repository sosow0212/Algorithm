package com.sosow0212.leetCode;

public class q1750 {

    public int minimumLength(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l <= r && s.charAt(l) == s.charAt(r)) {
            char c = s.charAt(l);

            while (l <= r && s.charAt(l) == c) {
                l++;
            }

            while (l <= r && s.charAt(r) == c) {
                r--;
            }
        }

        return r - l + 1;
    }


    public static void main(String[] args) {
        q1750 sol = new q1750();

        // 0
        System.out.println(sol.minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }
}
