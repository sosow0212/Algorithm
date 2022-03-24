package com.sosow0212.백준;

import java.util.Scanner;

public class q9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        long arr[] = new long[150];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

//      arr[n] = arr[n-1] + arr[n-5];

        for (int i = 6; i <= 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        for(int t=0; t<test; t++) {
            int n = sc.nextInt();
            System.out.println(arr[n]);
        }


    }
}
