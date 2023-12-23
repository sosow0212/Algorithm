package com.sosow0212.백준;

import java.util.Scanner;

public class q1083 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int max = arr[i];
            int maxi = i;

            for (int j = i + 1; j < n; j++) {
                if (m - (j - i) >= 0) {
                    if (max < arr[j]) {
                        max = arr[j];
                        maxi = j;
                    }
                }
            }
            for (int j = maxi; j > i; j--) {
                swap(arr, j, j - 1);
            }

            m -= (maxi - i);

            if (m <= 0) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
