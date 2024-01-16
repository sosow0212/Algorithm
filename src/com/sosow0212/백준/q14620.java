package com.sosow0212.백준;

import java.util.Scanner;

public class q14620 {

    static int n;
    static int[][] price;
    static int[][] flowers;
    static boolean[][] visited;
    static int answer;
    static int[][] pos = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        price = new int[n][n];
        flowers = new int[3][2];
        visited = new boolean[n][n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                price[i][j] = sc.nextInt();
            }
        }

        permutation(0);
        System.out.println(answer);
    }

    static void permutation(int index) {
        if (index == 3) {
            int total = 0;
            boolean[][] rent = new boolean[n][n];

            for (int[] flower : flowers) {
                int row = flower[0];
                int col = flower[1];

                for (int i = 0; i < pos.length; i++) {
                    int nr = row + pos[i][0];
                    int nc = col + pos[i][1];

                    if (!(nr >= 0 && nr < n && nc >= 0 && nc < n && !rent[nr][nc])) {
                        return;
                    }

                    rent[nr][nc] = true;
                    total += price[nr][nc];
                }
            }

            answer = Math.min(answer, total);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    flowers[index] = new int[]{i, j};
                    permutation(index + 1);
                    flowers[index] = new int[2];
                    visited[i][j] = false;
                }
            }
        }
    }
}
