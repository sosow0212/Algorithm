package com.sosow0212.etc;


import java.util.Scanner;

public class ttest {
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n];
        arr = new int[m];
        dfs(0, n, m);
    }

    public static void dfs(int depth, int n, int m) {
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
                dfs(depth + 1, n, m);
                visited[i] = false;
            }
        }
    }
}