package com.sosow0212.백준;

import java.util.Scanner;

public class q15652 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        dfs(1, 0);

    }

    static void dfs(int at, int depth) {
        if (depth == m) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
			return;
        }

        for (int i = at; i <= n; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
		return;
    }
}