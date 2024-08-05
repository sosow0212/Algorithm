package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class q2053 {

    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new LinkedHashMap<>();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();

            if (entry.getValue() > 1) {
                iterator.remove();
            }
        }

        ArrayList<String> filtered = new ArrayList<>(map.keySet());
        if (filtered.size() < k) {
            return "";
        }

        return filtered.get(k - 1);
    }

    public static void main(String[] args) {
        q2053 sol = new q2053();

        // "a"
//        System.out.println(sol.kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));

        System.out.println(sol.kthDistinct(new String[]{"a", "a"}, 1));
    }
}
