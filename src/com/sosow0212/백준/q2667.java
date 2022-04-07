package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q2667 {

    public static int N;
    public static int[][] Graph;
    public static boolean[][] Visited;
    public static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int count;

    // dfs
    public static void dfs(int r, int c) {
        Visited[r][c] = true;
        count++;

        for (int i = 0; i < pos.length; i++) {
            int nr = r + pos[i][0];
            int nc = c + pos[i][1];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && Graph[nr][nc] == 1 && !Visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }


    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Graph = new int[N][N];
        Visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                Graph[i][j] = str.charAt(j) - '0';
            }
        }


        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Graph[i][j] == 1 && !Visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
