package com.sosow0212.백준;

import java.util.Scanner;

public class q19947 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int y = sc.nextInt();
        int[] dp = new int[y + 1];
        dp[0] = h;
        for (int i = 1; i <= y; i++) {
            dp[i] = (int) (dp[i - 1] * 1.05);
            if (i >= 3) {
                dp[i] = (int) Math.max(dp[i], dp[i - 3] * 1.2);
            }
            if (i >= 5) {
                dp[i] = (int) Math.max(dp[i], dp[i - 5] * 1.35);
            }
        }
        System.out.println(dp[y]);
    }
}
