package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q1654_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        long left = 0;
        long right = arr[arr.length - 1];
        right++;

        while (left < right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < arr.length; i++) {
                sum += (arr[i] / mid);
            }

            if (sum < k) {
                right = mid;
            } else if (sum >= k) {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }
}
