package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) >= 2) {
                answer.add(i);
            }
        }

        return answer;
    }
}
