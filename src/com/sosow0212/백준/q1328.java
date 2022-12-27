package com.sosow0212.백준;

import java.util.Scanner;

public class q1328 {
    private static int n, l, r;
    private static long[][][] building;
    private static final long MOD_NUMBER = 1000000007;

    public static void main(String[] args) {
        initDataSet();
        initBuilding();
        countBuildingOrder();
        System.out.println(building[n][l][r]);
    }

    public static void countBuildingOrder() {
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    building[i][j][k] =
                            (building[i - 1][j][k - 1] + building[i - 1][j - 1][k] + building[i - 1][j][k] * (i - 2)) % MOD_NUMBER;
                }
            }
        }
    }

    public static void initBuilding() {
        building = new long[101][101][101];
        building[1][1][1] = 1;
    }

    public static void initDataSet() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
    }

}
