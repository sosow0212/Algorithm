package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q451 {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o2) - map.get(o1));

        StringBuilder answer = new StringBuilder();
        for (char k : keys) {
            int count = map.get(k);
            answer.append(Character.toString(k).repeat(count));
        }

        return answer.toString();
    }
}
