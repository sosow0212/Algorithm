package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q15661 {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        permutation(0, 0);
        System.out.println(answer);
    }

    static void permutation(int depth, int index) {
        if (depth == n) {
            return;
        }

        if (depth >= 1 && depth <= n - 1) {
            int start = 0;
            int link = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        start += map[i][j];
                        start += map[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += map[i][j];
                        link += map[j][i];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(start - link));
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
