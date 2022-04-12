package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q5800 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int total = 0;
            int avg = 0;
            int gap = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                total += arr[i];
            }

            Arrays.sort(arr);
            for (int i = 1; i < n; i++) {
                gap = Math.max(gap, arr[i] - arr[i - 1]);
            }

            System.out.println("Class " + (test + 1));
            System.out.println("Max " + arr[arr.length - 1] + ", Min " + arr[0] + ", Largest gap " + gap);
        }
    }
}
