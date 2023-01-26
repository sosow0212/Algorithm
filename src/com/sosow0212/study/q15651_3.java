package com.sosow0212.study;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15651 (N과M (3))
public class q15651_3 {
    private static StringBuilder sb = new StringBuilder();
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
        System.out.println(sb);
    }

    private static void recursion(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            recursion(index + 1);
        }
    }
}
