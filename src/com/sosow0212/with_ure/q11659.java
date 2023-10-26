package com.sosow0212.with_ure;

import java.util.Scanner;

public class q11659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int test = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        // 5 4 3 2 1
        // 5 9 12 14 15
        // 1 3

        for (int i = 0; i < test; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            if (s == e) {
                System.out.println(arr[s - 1]);
                continue;
            }

            if (s == 1) {
                System.out.println(dp[e - 1]);
                continue;
            }

            System.out.println(dp[e - 1] - dp[s - 2]);
        }
    }
}
