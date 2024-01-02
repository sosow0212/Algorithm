package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q16401 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int l = 1;
        int r = arr[arr.length - 1];

        int answer = 0;
        while (l <= r) {
            int mid = (l + r) / 2;

            int temp = 0;
            for (int i : arr) {
                temp += (i / mid);
            }

            if (temp >= k) {
                answer = Math.max(answer, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
