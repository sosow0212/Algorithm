package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q378 {

    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();

        for (int[] m : matrix) {
            for (int i : m) {
                list.add(i);
            }
        }

        Collections.sort(list);

        int left = 0;
        return list.get(k - 1);
    }
}
