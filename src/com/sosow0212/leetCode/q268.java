package com.sosow0212.leetCode;

import java.util.HashMap;
import java.util.Map;

public class q268 {

    public int missingNumber(int[] nums) {
        int answer = 0;
        int n = nums.length;

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            map.put(i, false);
        }

        for (int i : nums) {
            map.put(i, true);
        }

        for (int key : map.keySet()) {
            if (!map.get(key)) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
