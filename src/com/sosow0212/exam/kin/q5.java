package com.sosow0212.exam.kin;

public class q5 {

    static final int MOD = 10007;

    public static int solution(int n, int[] tops) {
        int[] dp = new int[100001 * 2];

        dp[1] = 1;
        dp[2] = tops[0] == 1 ? 3 : 2;
        dp[3] = tops[0] == 1 ? 4 : 3;

        for (int i = 4; i <= 2 * n + 1; i++) {
            int topIndex = (i / 2) - 1;
            boolean hasTop = tops[topIndex] == 1;

            if (hasTop && (i % 2 == 0)) {
                dp[i] = (2 * dp[i - 1] + dp[i - 2]) % MOD;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
        }

        return dp[2 * n + 1];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] tops = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        // 7704
        System.out.println(solution(n, tops));
    }
}
