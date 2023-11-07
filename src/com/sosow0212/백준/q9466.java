package com.sosow0212.백준;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class q9466 {

    static final Scanner sc = new Scanner(System.in);
    static final StringBuilder sb = new StringBuilder();

    static int start;
    static Set<Integer> answers;
    static int n;
    static boolean[] visited;
    static int[][] arr;

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            solve();
        }

        System.out.println(sb.toString());
    }

    static void solve() {
        n = sc.nextInt();
        arr = new int[2][n + 1];
        visited = new boolean[n + 1];
        start = 0;
        answers = new LinkedHashSet<>();

        for (int i = 1; i <= n; i++) {
            arr[0][i] = i;
            arr[1][i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            start = arr[0][i];

            if (arr[0][i] == arr[1][i]) {
                answers.add(arr[0][i]);
                continue;
            }

            dfs(i, arr[0][i], arr[1][i]);
            visited[i] = false;
        }

        sb.append(n - answers.size()).append("\n");
    }

    static void dfs(int index, int before, int node) {
        if (index >= 1 && before == node) {
            return;
        }

        if (start == node) {
            answers.add(start);
            return;
        }

        if (!visited[node]) {
            visited[node] = true;
            dfs(index + 1, arr[0][node], arr[1][node]);
            visited[node] = false;
        }
    }
}
