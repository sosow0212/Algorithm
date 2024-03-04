package com.sosow0212.woowa_study.set2;

import java.util.Arrays;
import java.util.Scanner;

public class q24049_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int col = sc.nextInt();
        int row = sc.nextInt();

        int[][] flowers = new int[row + 1][col + 1];
        for (int i = 1; i <= col; i++) {
            flowers[0][i] = sc.nextInt();
        }

        for (int j = 1; j <= row; j++) {
            flowers[j][0] = sc.nextInt();
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (flowers[i - 1][j] == flowers[i][j - 1]) {
                    flowers[i][j] = 0;
                } else {
                    flowers[i][j] = 1;
                }
            }
        }

        System.out.println(flowers[row][col]);
    }
}
