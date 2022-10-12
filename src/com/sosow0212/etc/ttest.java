package com.sosow0212.etc;

import java.util.Scanner;

public class ttest {

    static int answer;
    static int[] nums;
    static int target;

    static public int solution(int[] numbers, int tar) {
        answer = 0;
        nums = numbers;
        target = tar;

        dfs(0, 0);

        return answer;
    }

    static public void dfs(int depth, int sum) {
        if (depth == nums.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum + nums[depth]);
        dfs(depth + 1, sum - nums[depth]);
    }

    public static void main(String[] args) {
        int[] numbers = {4,1,2,1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }
}