package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class q1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o1) - map.get(o2));

        for (Integer key : keys) {
            Integer size = map.get(key);

            if (k - size >= 0) {
                k -= size;
                map.remove(key);
            } else {
                break;
            }
        }

        return map.keySet().size();
    }
}
