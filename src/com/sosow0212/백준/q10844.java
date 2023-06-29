package com.sosow0212.백준;

import java.util.Scanner;

public class q10844 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n + 1][10];

//        for (int i = 1; i <= n; i++) {
//            arr[i][0] = 1;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j < 10; j++) {
//                arr[i][j] =
//            }
//        }
        for (int i = 1; i < 10; i++) {
            arr[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            arr[i][0] = arr[i - 1][1];
            arr[i][9] = arr[i - 1][8];
            for (int j = 1; j < 9; j++) {
                arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += arr[n][i];
            result %= 1000000000;
        }
        System.out.println(result - 1);
        // 1 = 9
        // 2 = 10 ~ 99 = 90
        // 3 = 100 ~ 999 = 900
    }

}
