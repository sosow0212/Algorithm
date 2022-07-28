package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q2212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;

        if (n <= k) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        // 1 3 6 6 7 9

        Integer[] diff = new Integer[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff, Collections.reverseOrder());
        // 3 2 2 1 0

        for (int i = k - 1; i < n - 1; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}
