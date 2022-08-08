package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q5576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int sumA = 0;
        int sumB = 0;

        for(int i=0; i<10; i++) {
            arr1[i] = sc.nextInt();
        }

        for(int i=0; i<10; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i=9; i>=7; i--) {
            sumA += arr1[i];
            sumB += arr2[i];
        }

        System.out.println(sumA + " " + sumB);
    }
}
