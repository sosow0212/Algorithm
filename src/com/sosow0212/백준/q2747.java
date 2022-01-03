package com.sosow0212.백준;

import java.util.Scanner;

public class q2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[1000];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2; i<arr.length; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        System.out.println(arr[n]);
    }
}
