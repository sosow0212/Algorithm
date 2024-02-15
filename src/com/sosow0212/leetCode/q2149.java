package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.List;

public class q2149 {

    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        int index = 0;
        int[] answer = new int[nums.length];

        for (int i = 0; i < pos.size(); i++) {
            answer[index] = pos.get(i);
            index++;
            answer[index] = neg.get(i);
            index++;
        }

        return answer;
    }
}
