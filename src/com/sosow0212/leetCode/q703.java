package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q703 {

    static List<Integer> list;
    static int k;

    public q703(int k, int[] nums) {
        list = new ArrayList<>();
        this.k = k;

        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list);
    }

    public static int add(int val) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) == val) {
                return mid;
            }

            if (list.get(mid) > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        list.add(left, val);

        return list.get(list.size() - k);
    }
}
