package com.sosow0212.프로그래머스;

import java.util.HashSet;

public class 폰켓몬 {

    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int size = set.size();

        if(size >= len) {
            answer = len;
        } else {
            answer = size;
        }

        return answer;
    }


    public static void main(String[] args) {
        폰켓몬 sol = new 폰켓몬();
        int[] nums = {3, 3, 3, 2, 2, 4};
        System.out.println(sol.solution(nums)); // 3;
    }
}
