package com.sosow0212.leetCode;

import java.util.HashSet;
import java.util.Set;

public class q3 {

    public int lengthOfLongestSubstring(String s) {
        int answer = 0;

        Set<Character> alphabet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char now = s.charAt(right);

            if (alphabet.contains(now)) {
                while (alphabet.contains(now)) {
                    alphabet.remove(s.charAt(left));
                    left++;
                }
                alphabet.add(now);
            } else {
                alphabet.add(now);
                answer = Math.max(answer, right - left + 1);
            }


            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        q3 sol = new q3();

        // 1
        System.out.println(sol.lengthOfLongestSubstring(" "));
    }
}
