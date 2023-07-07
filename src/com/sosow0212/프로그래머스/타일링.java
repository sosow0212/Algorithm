package com.sosow0212.프로그래머스;

public class 타일링 {

    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = dp[1] + dp[2];

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        타일링 sol = new 타일링();

        // 5
        System.out.println(sol.solution(4));
    }
}
