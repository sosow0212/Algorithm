package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q16435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0; i<n; i++) {
            if(l >= arr[i]) {
                l++;
            }
        }

        System.out.println(l);
    }
}
