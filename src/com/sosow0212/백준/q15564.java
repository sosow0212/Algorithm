package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q15564 {

    static int[] arr;
    static boolean[] visited;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n + 1];

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        dfs(n, m, 0);
        System.out.println(sb);

    }

    static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
        return;
    }
}
