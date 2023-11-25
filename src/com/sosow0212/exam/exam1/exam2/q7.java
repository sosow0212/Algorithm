package com.sosow0212.exam.exam1.exam2;

public class q7 {

    public int solution(int[] schedules) {
        int[] dp = new int[schedules.length + 1];

        dp[0] = schedules[0];
        dp[1] = Math.max(schedules[0], schedules[1]);

        for (int i = 2; i < schedules.length; i++) {
            dp[i] = Math.max(dp[i - 2] + schedules[i], dp[i - 1]);
        }

        for (int i : dp) {
            System.out.println(i);
        }
        return dp[schedules.length - 1];
    }

    public static void main(String[] args) {
        q7 sol = new q7();

        // 210
        System.out.println(sol.solution(new int[]{30, 30, 60, 90, 60, 15, 15, 60}));
    }
}
