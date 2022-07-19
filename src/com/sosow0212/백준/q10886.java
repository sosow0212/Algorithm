package com.sosow0212.백준;

import java.util.Scanner;

public class q10886 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[2];

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[temp]++;
        }

        if (arr[0] > arr[1]) {
            System.out.println("Junhee is not cute!");
        } else {
            System.out.println("Junhee is cute!");
        }
    }
}
