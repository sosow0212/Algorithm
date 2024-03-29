package com.sosow0212.프로그래머스;

public class 멀리뛰기 {

    static public long solution(int n) {

        long dp[] = new long[2001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 2000; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;

        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(solution(4)); // 5
    }
}
