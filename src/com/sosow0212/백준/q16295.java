package com.sosow0212.백준;

import java.util.Scanner;

public class q16295 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[31][31];

        arr[1][1] = 1;
        for(int i=2; i<=30; i++) {
            arr[i][1] = 1;
            arr[i][i] = 1;
        } // 양끝 1처리

        for(int i=3; i<=30; i++) {
            for(int j=2; j<=i-1; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }

        System.out.println(arr[n][k]);



    }
}
