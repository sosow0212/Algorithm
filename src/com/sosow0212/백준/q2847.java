package com.sosow0212.백준;

import java.util.Scanner;

public class q2847 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxLevel = arr[arr.length - 1];

        int count = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (maxLevel <= arr[i]) {
                arr[i] -= 1;
                count++;
            }

            maxLevel = arr[i];
        }

        System.out.println(count);
    }
}
