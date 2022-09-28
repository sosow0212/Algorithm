package com.sosow0212.프로그래머스;

import java.util.HashSet;

public class 소수만들기 {

    static int answer;

    static public int solution(int[] nums) {
        answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    int num = nums[i] + nums[j] + nums[k];
                    if (isPrime(num)) {
                        answer++;
                    }
                }
            }

        }

        return answer;
    }


    static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 7, 6, 4})); // 4
    }
}
