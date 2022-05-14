package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q15655 {

    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n + 1];
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        dfs(0,0);
        System.out.println(sb);

    }

    static void dfs(int at, int depth) {
        if (depth == m) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }

        }
        return;
    }
}
