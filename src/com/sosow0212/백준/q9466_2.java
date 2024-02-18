package com.sosow0212.백준;

import java.util.Scanner;

public class q9466_2 {

    static int n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] done;
    static int loop;

    static final Scanner sc = new Scanner(System.in);
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }

        System.out.println(sb.toString());
    }

    static void solve() {
        n = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        visited = new boolean[n + 1];
        done = new boolean[n + 1];
        loop = 0;

        for (int i = 1; i <= n; i++) {
            dfs(i);
        }

        sb.append(n - loop)
                .append("\n");
    }

    static void dfs(int node) {
        if (done[node]) {
            return;
        }

        if (visited[node]) {
            loop++;
            done[node] = true;
        }

        visited[node] = true;
        dfs(arr[node]);
        done[arr[node]] = true;
        visited[node] = false;
    }
}
