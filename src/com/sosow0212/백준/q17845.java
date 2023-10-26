package com.sosow0212.백준;

import java.util.Scanner;

public class q17845 {

    // fail 시간초과 -> dp로 개선

    static int n;
    static int m;
    static int answer = 0;
    static boolean[] visited;
    static int lowValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = Integer.MIN_VALUE;
        visited = new boolean[m];
        lowValue = Integer.MAX_VALUE;

        int[][] arr = new int[m][2];

        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            lowValue = Math.min(lowValue, arr[i][1]);
        }

        permutation(0, arr, n, 0);

        System.out.println(answer);
    }

    static void permutation(int index, int[][] arr, int status, int sum) {
        if (index == m) {
            return;
        }

        for (int i = 0; i < m; i++) {
            if (!visited[i] && status - arr[i][1] >= 0) {
                visited[i] = true;
                answer = Math.max(answer, sum + arr[i][0]);
                permutation(index + 1, arr, status - arr[i][1], sum + arr[i][0]);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, sum);
    }
}
