package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        int sum = 0;

        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            sum += a[i] * b[i];
        }

        System.out.println(sum);
    }
}
