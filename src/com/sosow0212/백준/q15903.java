package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q15903 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }


        while (m != 0) {
            Arrays.sort(arr);
            long sum = arr[0] + arr[1];
            arr[0] = sum;
            arr[1] = sum;
            m--;
        }

        System.out.println(Arrays.stream(arr).sum());
    }
}
