package com.sosow0212.백준;

import java.util.Scanner;

public class q14889 {

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        permutation(0, 0);

        System.out.println(answer);
    }

    static void permutation(int depth, int index) {
        if (depth == n / 2) {
            int sumA = 0;
            int sumB = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        sumA += arr[i][j];
                        sumA += arr[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        sumB += arr[i][j];
                        sumB += arr[j][i];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(sumA - sumB));
            return;
        }

        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
