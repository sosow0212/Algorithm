package com.sosow0212.백준;

import java.util.Scanner;

public class q15650 {

    static int[] arr;
    static boolean[] visited;
    static int n, m;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n + 1];
        dfs(n, m, 0);
        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
        return;

    }
}
