package com.sosow0212.woowa_study.set9;

import java.util.Scanner;

public class q18229 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int answerIndex = 0;

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dp = new int[n];

        for (int col = 0; col < m; col++) {
            for (int peopleIndex = 0; peopleIndex < n; peopleIndex++) {
                dp[peopleIndex] += arr[peopleIndex][col];

                if (dp[peopleIndex] >= k) {
                    count = col + 1;
                    answerIndex = peopleIndex + 1;
                    System.out.println(answerIndex + " " + count);

                    return;
                }
            }
        }
    }
}
