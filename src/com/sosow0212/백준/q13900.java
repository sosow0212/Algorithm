package com.sosow0212.백준;

import java.util.Scanner;

public class q13900 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Long[] arr = new Long[n + 1];
        Long[] sum = new Long[n + 1];

        arr[0] = 0L;
        sum[0] = 0L;

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
            sum[i] = arr[i] + sum[i - 1];
        }

        Long temp = 0L;
        for (int i = 2; i <= n; i++) {
            temp += arr[i] * sum[i - 1];
        }

        System.out.println(temp);
    }
}
