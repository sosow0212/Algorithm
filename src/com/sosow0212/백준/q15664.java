package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q15664 {

    private static int n, m;
    private static int[] map;
    private static int[] arr;
    private static boolean[] visited;

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n];
        arr = new int[m];
        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            map[i] = sc.nextInt();
        }

        Arrays.sort(map);

        StringBuilder sb = new StringBuilder();

        dfs(0, 0);

        System.out.print(sb);

    }

    private static void dfs(int index, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
        } else {
            int b = 0;
            for (int i = index; i < n; i++) {
                if (!visited[i]) {
                    if (b == map[i]) {
                        continue;
                    }

                    visited[i] = true;
                    arr[depth] = map[i];
                    dfs(i + 1, depth + 1);
                    visited[i] = false;

                    b = map[i];

                }
            }
        }
    }
}
