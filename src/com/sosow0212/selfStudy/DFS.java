package com.sosow0212.selfStudy;

import java.util.Scanner;

public class DFS {

    private static int N;
    private static int[][] Graph;
    private static boolean[] Visited;

    public static void dfs(int i) {
        Visited[i] = true;
        System.out.print(i + " ");
        for (int j = 1; j < N + 1; j++) {
            if (Graph[i][j] == 1 && Visited[j] == false) {
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}
