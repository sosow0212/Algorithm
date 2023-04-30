package com.sosow0212.백준;

import java.util.Scanner;

public class q1940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int end = i + 1;

            while (end < n) {
                sum = arr[i];
                sum += arr[end++];

                if (sum == m) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
