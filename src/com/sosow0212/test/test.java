package com.sosow0212.test;

import java.util.Scanner;

public class test {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n + 1];
        dfs(n, m, 0);

    }

    public static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
        return;

    }

}