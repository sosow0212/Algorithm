package com.sosow0212.woowa_study.set10;

import java.util.Scanner;

public class q14600 {

    static int k;
    static int n;
    static int num = 0;
    static int[][] arr = new int[130][130];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        int col = sc.nextInt() - 1;
        int row = sc.nextInt() - 1;

        arr[row][col] = -1;
        n = (int) Math.pow(2, k);

        dfs(0, 0, n);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }

    static void dfs(int r, int c, int size) {
        int tileSize = size / 2;
        num += 1;

        if (divide(r, c, tileSize)) {
            arr[r + tileSize - 1][c + tileSize - 1] = num;
        }

        if (divide(r, c + tileSize, tileSize)) {
            arr[r + tileSize - 1][c + tileSize] = num;
        }

        if (divide(r + tileSize, c, tileSize)) {
            arr[r + tileSize][c + tileSize - 1] = num;
        }

        if (divide(r + tileSize, c + tileSize, tileSize)) {
            arr[r + tileSize][c + tileSize] = num;
        }

        if (size == 2) {
            return;
        }

        dfs(r, c, tileSize);
        dfs(r, c + tileSize, tileSize);
        dfs(r + tileSize, c, tileSize);
        dfs(r + tileSize, c + tileSize, tileSize);
    }

    static boolean divide(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
