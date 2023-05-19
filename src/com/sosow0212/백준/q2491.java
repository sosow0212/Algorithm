package com.sosow0212.백준;

import java.util.Scanner;

public class q2491 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] upperDp = new int[n];
        int[] lowerDp = new int[n];
        int answer = Integer.MIN_VALUE;

        upperDp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                upperDp[i] = upperDp[i - 1] + 1;
            } else {
                upperDp[i] = 1;
            }
            answer = Math.max(answer, upperDp[i]);
        }

        lowerDp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i - 1]) {
                lowerDp[i] = lowerDp[i - 1] + 1;
            } else {
                lowerDp[i] = 1;
            }
            answer = Math.max(answer, lowerDp[i]);
        }

        System.out.println(answer);
    }
}
