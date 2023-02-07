package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q13164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;
        int[] arr = new int[n];
        int[] gap = new int[n - 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            gap[i] = arr[i + 1] - arr[i];
        }

        // 2 2 1 4 -> 1 2 2 4 -> 1 + 2
        Arrays.sort(gap);

        for(int i=0; i<n-k; i++) {
            answer += gap[i];
        }
        System.out.println(answer);
    }
}
