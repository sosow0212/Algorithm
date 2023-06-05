package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q2230 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int answer = Integer.MAX_VALUE;

        while (start <= end && end < n) {
            if (arr[end] - arr[start] >= m) {
                answer = Math.min(answer, arr[end] - arr[start]);
                start++;
            } else {
                end ++;
            }
        }

        System.out.println(answer);
    }
}
