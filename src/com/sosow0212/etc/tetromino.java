package com.sosow0212.etc;

import java.util.Scanner;

public class tetromino {
    static int col, row, ans;
    static int arr[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        col = sc.nextInt();
        row = sc.nextInt();
        ans = 0;
        int colIndex = 0;
        arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        if(row < 4) {
            System.out.println(0 + " " + 0);
        }

        for (int i = 0; i < col; i++) {
            if (arr[row - 1][i] == 0) {
                colIndex = i;
            }
        }

        arr[row-1][colIndex] = 1;
        arr[row-2][colIndex] = 1;
        arr[row-3][colIndex] = 1;
        arr[row-4][colIndex] = 1;

        for(int i=0; i<row; i++) {
            int temp = 0;
            for(int j=0; j<col; j++) {
                temp += arr[i][j];
            }
            if(temp == col) {
                ans ++;
            }
        }

        int ansCol = colIndex + 1;
        System.out.println(ansCol + " " + ans);
    }
}
