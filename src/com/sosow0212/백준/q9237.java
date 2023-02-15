package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q9237 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        // 2 3 3 4
        int day = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            day = Math.max(day, arr[i] + i + 1);
        }

        System.out.println(day + 1);
    }
}
