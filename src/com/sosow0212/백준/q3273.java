package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q3273 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {
                answer++;
                left ++;
                continue;
            }

            if (sum <= x) {
                left++;
                continue;
            }

            if (sum > x) {
                right--;
            }
        }

        System.out.println(answer);
    }
}
