package com.sosow0212.with_ure;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        int size = nums.length / 2;

        for (int num : nums) {
            set.add(num);
        }

        if (set.size() <= size) {
            answer = set.size();
        }

        if (set.size() > size) {
            answer = size;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        System.out.println(solution(nums)); // 2
    }
}
