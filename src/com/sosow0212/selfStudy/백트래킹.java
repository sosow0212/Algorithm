package com.sosow0212.selfStudy;

import java.util.Scanner;

public class 백트래킹 {
    // 15649

    static int n, m;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visit = new boolean[n];
        arr = new int[m];
        dfs(n, m, 0);
    }

    static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);
                visit[i] = false;
            }
        }
    }
}
