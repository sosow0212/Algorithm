package com.sosow0212.백준;

import java.util.Scanner;

public class q11724 {
    static int n, m;
    static int v, e, ans;
    static int[][] graph = new int[1001][1001];
    static boolean[] visited = new boolean[1001];

    public static void dfs(int index) {
        if (visited[index])
            return;

        visited[index] = true;
        for (int i = 1; i <= v; i++) {
            if (graph[index][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        int v1, v2;

        for (int i = 0; i < e; i++) {
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            graph[v1][v2] = graph[v2][v1] = 1;
        }

        ans = 0;

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }

        System.out.println(ans);

    }
}
