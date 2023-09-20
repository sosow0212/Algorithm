package com.sosow0212.woowa_study.set2;

import java.util.Scanner;

public class q24049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] map = new int[row + 1][col + 1];

        for (int i = 1; i < row + 1; i++) {
            map[i][0] = sc.nextInt();
        }

        for (int i = 1; i < col + 1; i++) {
            map[0][i] = sc.nextInt();
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                map[i][j] = map[i - 1][j] == map[i][j - 1] ? 0 : 1;
            }
        }

        System.out.println(map[row][col]);
    }
}
