package com.sosow0212.leetCode;

public class q1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int answer = 0;
        int left = 0;
        int now = 0;

        for (int i = 0; i < s.length(); i++) {
            now += Math.abs(s.charAt(i) - t.charAt(i));

            while (maxCost < now) {
                now -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            answer = Math.max(answer, i - left + 1);
        }

        return answer;
    }
}
