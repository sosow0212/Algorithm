package com.sosow0212.leetCode;

import java.util.HashMap;

public class q137 {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = -1;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        q137 sol = new q137();
        int[] num = {-2, -2, 1, 1, 4, 1, 4, 4, -4, -2};

        // -4
        System.out.println(sol.singleNumber(num));
    }
}
