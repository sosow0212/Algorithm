package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Scanner;


public class q14267 {

    private static int n, m;
    private static ArrayList<Integer>[] list;
    private static int[] dp;

    public static void main(String[] args) {
        initData();
        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        dp = new int[n + 1];

        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int temp = sc.nextInt();
            if (temp == -1) {
                continue;
            }
            list[temp].add(i);
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            dp[a] += b;
        }

        dfs(1);
    }

    private static void dfs(int index) {
        for (int i : list[index]) {
            dp[i] += dp[index];
            dfs(i);
        }
    }
}
