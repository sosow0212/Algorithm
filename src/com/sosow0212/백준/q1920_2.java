package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q1920_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = n - 1;
            int target = arr2[i];
            int answer = 0;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (arr[mid] == target) {
                    answer = 1;
                    break;
                } else if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            System.out.println(answer);
        }
    }
}
