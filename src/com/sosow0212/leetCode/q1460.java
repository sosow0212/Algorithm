package com.sosow0212.leetCode;

import java.util.HashMap;

public class q1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : target) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : arr) {
            if (!map.containsKey(i)) {
                return false;
            }

            map.put(i, map.get(i) - 1);
            if (map.get(i) == 0) {
                map.remove(i);
            }
        }

        return map.isEmpty();
    }
}
