package com.sosow0212.백준;

import java.util.Scanner;

public class q2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int ans = 0, row = 0, col = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > ans) {
                    ans = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println(ans);
        System.out.println((row + 1) + " " + (col + 1));
    }
}
