package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q10986 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long answer = 0;

        long[] arr = new long[n];
        long[] prefix = new long[n];
        long[] countQuery = new long[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            int p = (int) (prefix[i] % m);

            if (p == 0) {
                answer++;
            }

            countQuery[p]++;
        }

        for (int i = 0; i < m; i++) {
            if (countQuery[i] > 1) {
                long count = countQuery[i];
                answer = answer + (count * (count - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
