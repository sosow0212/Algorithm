package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q2467 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int a = 0;
        int b = 0;

        int left = 0;
        int right = n - 1;
        int minTemp = Integer.MAX_VALUE;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < minTemp) {
                minTemp = Math.abs(sum);
                a = arr[left];
                b = arr[right];

                if (sum == 0) {
                    break;
                }
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(a + " " + b);
    }
}
