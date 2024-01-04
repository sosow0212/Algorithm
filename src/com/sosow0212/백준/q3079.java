package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q3079 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long answer = Long.MAX_VALUE;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long left = 1; // 7
        long right = (long) m * arr[arr.length - 1]; // 최대로 걸리는 시간 (사람 수 * 가장 느린 심사관)

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int time : arr) {
                sum += mid / time;
            }

            if (sum >= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
