package com.sosow0212.백준;

import java.util.Scanner;

public class q1806_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int diff = Integer.MAX_VALUE;

        while (left <= n && right <= n) {
            if (sum < s) {
                sum += arr[right];
                right++;
            } else {
                diff = Math.min(diff, right - left);
                sum -= arr[left];
                left++;
            }
        }

        if (diff == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(diff);
        }
    }
}
