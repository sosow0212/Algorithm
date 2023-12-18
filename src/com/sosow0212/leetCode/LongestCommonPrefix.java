package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String answer = "";

        if (strs.length == 1) {
            return strs[0];
        }

        int minSize = Integer.MAX_VALUE;
        for (String str : strs) {
            minSize = Math.min(str.length(), minSize);
        }

        for (int i = 1; i < minSize; i++) {
            Set<String> set = new LinkedHashSet<>();

            for (String str : strs) {
                set.add(str.substring(0, i));
            }

            if (set.size() == 1) {
                ArrayList<String> list = new ArrayList<>(set);
                answer = list.get(0);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();

        // a
        System.out.println(sol.longestCommonPrefix(new String[]{"ab", "a"}));
    }
}
