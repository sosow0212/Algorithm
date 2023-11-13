package com.sosow0212.백준;

import java.util.Scanner;

public class q21921 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int sum = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        int max = sum;
        int count = 1;

        for (int i = x; i < n; i++) {
            sum += arr[i] - arr[i - x];
            if (max == sum) {
                count++;
            } else if (max < sum) {
                max = sum;
                count = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
