package com.sosow0212.백준;

import java.util.Scanner;

public class q10819 {
    static int n, result;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];
        ans = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0);
        System.out.println(result);
    }

    static void dfs(int count) {
        if (count == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(ans[i] - ans[i + 1]);
            }
            result = Math.max(result, sum);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans[count] = arr[i];
                visited[i] = true;
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
}
