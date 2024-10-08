package com.sosow0212.leetCode;

import java.util.HashMap;

public class q1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        int answer = 0;

        for (char c : allowed.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (String s : words) {
            int temp = 0;

            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);

                if (map.containsKey(now)) {
                    temp++;
                }
            }

            if (temp == s.length()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        q1684 sol = new q1684();

        // 2
        System.out.println(
                sol.countConsistentStrings(
                        "ab",
                        new String[]{"ad", "bd", "aaab", "baa", "badab"}
                )
        );
    }
}
