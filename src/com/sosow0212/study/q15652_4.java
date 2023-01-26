package com.sosow0212.study;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15652 (N과M (4))
public class q15652_4 {
    private static int n, m;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m + 1];
        visited = new boolean[n + 1];
        recursion(0);
    }

    private static void recursion(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (index != 0 && arr[index - 1] > i) {
                continue;
            }
            arr[index] = i;
            recursion(index + 1);
        }
    }
}
