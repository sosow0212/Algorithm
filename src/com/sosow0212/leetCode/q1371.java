package com.sosow0212.leetCode;

import java.util.HashMap;
import java.util.Map;

public class q1371 {

    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> bits = new HashMap<>();
        bits.put(0, -1);

        int answer = 0;
        int now = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a') {
                now ^= (1);
            } else if (c == 'e') {
                now ^= (1 << 1);
            } else if (c == 'i') {
                now ^= (1 << 2);
            } else if (c == 'o') {
                now ^= (1 << 3);
            } else if (c == 'u') {
                now ^= (1 << 4);
            }

            if (bits.containsKey(now)) {
                answer = Math.max(answer, i - bits.get(now));
            } else {
                bits.put(now, i);
            }

            System.out.println(bits);
        }

        return answer;
    }

    public static void main(String[] args) {
        q1371 sol = new q1371();

        // 13, leetminicowor
        System.out.println(sol.findTheLongestSubstring("eleetminicoworoep"));
    }
}
