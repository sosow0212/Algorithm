package com.sosow0212.woowacourse_study;

import java.util.Scanner;

public class q1051 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; k + i < n && k + j < m; k++) {
                    if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j + k]) {
                        if ((k + 1) * (k + 1) > answer) {
                            answer = (k + 1) * (k + 1);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
