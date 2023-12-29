package com.sosow0212.백준;

import java.util.Scanner;

public class q2239 {

    static final int N = 9;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        permutation();
    }

    static void permutation() {
        int[] zeroIdx = findZeroIdx();

        if (zeroIdx[0] == -1) {
            print();
            System.exit(0);
        }

        for (int i = 1; i <= N; i++) {
            if (isValid(zeroIdx, i)) {
                map[zeroIdx[0]][zeroIdx[1]] = i;
                permutation();
                map[zeroIdx[0]][zeroIdx[1]] = 0;
            }

        }
    }

    static int[] findZeroIdx() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static boolean isValid(int[] zeroIdx, int num) {
        int row = zeroIdx[0];
        int col = zeroIdx[1];

        for (int i = 0; i < N; i++) {
            if (map[row][i] == num || map[i][col] == num) {
                return false;
            }
        }

        int blockRow = (row / 3) * 3;
        int blockCol = (col / 3) * 3;

        for (int i = blockRow; i < blockRow + 3; i++) {
            for (int j = blockCol; j < blockCol + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
