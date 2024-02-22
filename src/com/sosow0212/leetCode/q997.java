package com.sosow0212.leetCode;

import java.util.HashMap;
import java.util.Map;

public class q997 {

    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] t : trust) {
            map.put(t[0], -1);

            if (!map.containsKey(t[1]) || map.get(t[1]) != -1) {
                map.put(t[1], map.getOrDefault(t[1], 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n - 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
