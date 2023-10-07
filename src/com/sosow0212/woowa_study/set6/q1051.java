package com.sosow0212.woowa_study.set6;

import java.util.Scanner;

public class q1051 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int size = Math.min(n, m);
        int answer = Integer.MIN_VALUE;

        while (size > 1) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    int temp = arr[i][j];

                    if (temp == arr[i + size - 1][j] && temp == arr[i + size - 1][j + size - 1] && temp == arr[i][j + size - 1]) {
                        System.out.println(size * size);
                        return;
                    }
                }
                size--;
            }
        }

        System.out.println(size * size);
    }
}
