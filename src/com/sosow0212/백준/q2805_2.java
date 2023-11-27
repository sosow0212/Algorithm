package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q2805_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr[arr.length - 1];

        while (left < right) {
            int mid = (left + right) / 2;

            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] - mid >= 0) {
                    sum += (arr[i] - mid);
                }
            }

            if (sum < m) {
                right = mid;
            } else if (sum >= m) {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }
}
