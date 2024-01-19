package com.sosow0212.백준;

import java.util.Scanner;

public class q2851 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[11];
        for (int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            arr[i] = arr[i - 1] + num;

            if (arr[i] == 100) {
                System.out.println(100);
                return;
            }
        }

        int diff = Integer.MAX_VALUE;
        int value = -1;

        for (int i : arr) {
            if (Math.abs(i - 100) <= diff) {
                diff = Math.abs(i - 100);
                value = i;
            }
        }

        System.out.println(value);
    }
}
