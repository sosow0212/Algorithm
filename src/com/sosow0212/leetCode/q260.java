package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class q260 {

    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o1) - map.get(o2));

        List<Integer> answer = new ArrayList<>();
        for (int k : keys) {
            if (map.get(k) == 1) {
                answer.add(k);
            } else {
                break;
            }
        }

        int[] re = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            re[i] = answer.get(i);
        }

        return re;

    }
}
