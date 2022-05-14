package com.sosow0212.test;

import java.util.Scanner;

public class 백트래킹 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n + 1];
        cycle(n, m, 0);
    }

    static void cycle(int n, int m, int depth) {
        if (depth == m) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                cycle(n, m, depth + 1);
                visited[i] = false;
            }
        }
        return;
    }
}
