package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q2012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i] - (i + 1));
        }

        System.out.println(sum);

        // 1 1 2 3 5 -> 0 -1 -1 -1 0
    }
}
