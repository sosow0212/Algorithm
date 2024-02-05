package com.sosow0212.leetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class q387 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }
}
