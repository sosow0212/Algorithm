package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 0;
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (true) {
                if (left == i) {
                    left++;
                } else if (right == i) {
                    right--;
                }

                if (left >= right)
                    break;

                if (arr[left] + arr[right] > arr[i]) {
                    right--;
                } else if (arr[left] + arr[right] < arr[i]) {
                    left++;
                } else {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
