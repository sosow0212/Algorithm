package com.sosow0212.프로그래머스다시;

public class 멀리뛰기 {

    public long solution(int n) {
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 2000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        멀리뛰기 sol = new 멀리뛰기();
        System.out.println(sol.solution(4)); // 5
        System.out.println(sol.solution(3)); // 3
    }
}
