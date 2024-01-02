package com.sosow0212.백준;

import java.util.Scanner;

public class q2580 {

    static final int N = 9;

    static int[][] map;
    static int[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        permutation();
    }

    static void permutation() {
        int[] zeroIdx = findZeroIdx();

        if (zeroIdx[0] == -1) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j])
                            .append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
            System.exit(0);
        }

        for (int i = 1; i <= N; i++) {
            if (isPermit(zeroIdx, i)) {
                map[zeroIdx[0]][zeroIdx[1]] = i;
                permutation();
                map[zeroIdx[0]][zeroIdx[1]] = 0;
            }
        }
    }

    static boolean isPermit(final int[] pos, final int val) {
        int row = pos[0];
        int col = pos[1];

        int nr = ((row + 3) / 3 - 1) * 3;
        int nc = ((col + 3) / 3 - 1) * 3;

        // (0, 1, 2) --> 0  // (3,4,5) --> 1 // (6,7,8) --> 2
        // 0 3 6

        for (int i = nr; i < nr + 3; i++) {
            for (int j = nc; j < nc + 3; j++) {
                if (pos[0] == i && pos[1] == j) {
                    continue;
                }

                if (map[i][j] == val) {
                    return false;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == row) {
                continue;
            }

            if (map[i][col] == val) {
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == col) {
                continue;
            }

            if (map[row][i] == val) {
                return false;
            }
        }

        return true;

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
}
