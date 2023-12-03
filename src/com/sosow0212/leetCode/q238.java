package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q238 {

    public static int[] productExceptSelf(int[] nums) {
        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();

        int j = 0;
        int p1 = 1;
        int p2 = 1;

        while (right.size() != nums.length || left.size() != nums.length) {
            if (j >= nums.length - 1) {
                right.add(p1 * nums[j]);
                left.add(p2 * nums[0]);
                break;
            }

            right.add(p1 * nums[j]);
            left.add(p2 * nums[nums.length - 1 - j]);

            int next1 = p1 * nums[j];
            int next2 = p2 * nums[nums.length - 1 - j];

            right.add(next1 * nums[j + 1]);
            left.add(next2 * nums[nums.length - 2 - j]);

            p1 = next1 * nums[j + 1];
            p2 = next2 * nums[nums.length - 2 - j];

            j += 2;
        }

        int[] fin = new int[nums.length];
        int i = 0;
        while (i < fin.length / 2) {
            if (i == 0 || i == fin.length - 1) {
                fin[0] = left.get(left.size() - 2);
                fin[fin.length - 1] = right.get(right.size() - 2);
            } else {
                fin[i] = right.get(i - 1) * left.get(left.size() - 2 - i % left.size());
                fin[fin.length - 1 - i] = left.get(i - 1) * right.get(right.size() - 2 - (i % right.size()));
            }
            i++;
        }
        if (fin.length % 2 == 1) {
            fin[(fin.length / 2)] = right.get(right.size() / 2 - 1) * left.get(left.size() / 2 - 1);
        }
        return fin;
    }

    public static void main(String[] args) {
        // 0 0 9 0 0
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, -1, 0, -3, 3})));

    }
}
