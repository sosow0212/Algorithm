package com.sosow0212.백준;

import java.util.Scanner;

public class q1421 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int w = sc.nextInt();

        int[] tree = new int[1001];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        int ans = 0;

        for (int i = 1; i <= 10000; ++i) {
            int target = 0;
            int cost = 0;
            int count = 0;
            int income = 0;

            for (int j = 0; j < n; ++j) {
                count = tree[j] / j;

                cost = (int) ((tree[j] - 0.5) / j);
                income = (j * count * w - c * cost);

                if (income > 0) {
                    target += income;
                }
            }

            ans = Math.max(ans, target);
        }

        System.out.println(ans);
    }
}
