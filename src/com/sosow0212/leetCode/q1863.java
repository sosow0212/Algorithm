package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.List;

public class q1863 {

    static List<List<Integer>> list;
    static int answer;

    public int subsetXORSum(int[] nums) {
        list = new ArrayList<>();
        answer = 0;

        permutation(0, 0, nums, new ArrayList<>());

        for (List<Integer> integers : list) {
            int sum = 0;
            for (Integer integer : integers) {
                sum ^= integer;
            }
            answer += sum;
        }

        return answer;
    }

    static void permutation(int index, int start, int[] nums, List<Integer> temp) {
        if (!temp.isEmpty()) {
            list.add(new ArrayList<>(temp));
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            permutation(index + 1, i + 1, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        q1863 solution = new q1863();
        // 6
        System.out.println(solution.subsetXORSum(new int[]{1, 2}));
    }
}
