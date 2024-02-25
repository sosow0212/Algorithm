package com.sosow0212.leetCode;

import java.util.HashSet;
import java.util.Set;

public class q217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return set.size() != nums.length;
    }
}
