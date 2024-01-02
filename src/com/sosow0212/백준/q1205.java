package com.sosow0212.백준;

import java.util.Scanner;

public class q1205 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int point = sc.nextInt();
        int maximum = sc.nextInt();

        if (n == 0) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr[arr.length - 1] >= point) {
            System.out.println(-1);
            return;
        }

        int order = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (point >= arr[i]) {
                break;
            }

            if (point >= arr[i + 1]) {
                order++;
                break;
            } else {
                order++;
            }
        }

        System.out.println(order);
    }
}
