package com.sosow0212.백준;

import java.util.*;

public class q15649 {
    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 1~n 까지 수
        int M = in.nextInt(); // m개의 수를 선택해서 조합을 만들어야함

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);

    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}