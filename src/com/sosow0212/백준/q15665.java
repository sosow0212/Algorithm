package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q15665 {

    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        visited = new boolean[n];

        dfs(0, new int[m]);
        System.out.println(sb.toString());
    }

    private static void dfs(int index, int[] list) {
        if (index == m) {
            for (int i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for (int i = 0; i < n; i++) {
            if (before != arr[i]) {
                before = arr[i];
                list[index] = arr[i];
                dfs(index + 1, list);
            }
        }
    }
}
