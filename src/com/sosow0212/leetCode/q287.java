package com.sosow0212.leetCode;

import java.util.HashMap;

public class q287 {

    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                return i;
            }

            map.put(i, 1);
        }

        return -1;
    }
}
