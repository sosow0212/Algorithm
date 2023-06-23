package com.sosow0212.백준;

import java.util.Scanner;

public class q18430 {

    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) {
        initData();
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int index, int sum) {
        if (index == n * m) {
            if (answer < sum)
                answer = sum;
            return;
        }

        int row = index / m;
        int col = index % m;

        if (!visited[row][col]) {
            if (row + 1 < n && col + 1 < m && !visited[row + 1][col] && !visited[row][col + 1]) {
                visited[row][col] = true;
                visited[row + 1][col] = true;
                visited[row][col + 1] = true;

                int temp = sum + 2 * (map[row][col]) + map[row + 1][col] + map[row][col + 1];
                dfs(index + 1, temp);

                visited[row][col] = false;
                visited[row + 1][col] = false;
                visited[row][col + 1] = false;
            }

            if (row + 1 < n && col - 1 >= 0 && !visited[row + 1][col] && !visited[row][col - 1]) {
                visited[row][col] = true;
                visited[row + 1][col] = true;
                visited[row][col - 1] = true;

                int temp = sum + 2 * (map[row][col]) + map[row + 1][col] + map[row][col - 1];
                dfs(index + 1, temp);

                visited[row][col] = false;
                visited[row + 1][col] = false;
                visited[row][col - 1] = false;
            }

            if (row - 1 >= 0 && col - 1 >= 0 && !visited[row - 1][col] && !visited[row][col - 1]) {
                visited[row][col] = true;
                visited[row - 1][col] = true;
                visited[row][col - 1] = true;

                int temp = sum + 2 * (map[row][col]) + map[row - 1][col] + map[row][col - 1];
                dfs(index + 1, temp);

                visited[row][col] = false;
                visited[row - 1][col] = false;
                visited[row][col - 1] = false;
            }

            if (row - 1 >= 0 && col + 1 < m && !visited[row - 1][col] && !visited[row][col + 1]) {
                visited[row][col] = true;
                visited[row - 1][col] = true;
                visited[row][col + 1] = true;

                int temp = sum + 2 * (map[row][col]) + map[row - 1][col] + map[row][col + 1];
                dfs(index + 1, temp);

                visited[row][col] = false;
                visited[row - 1][col] = false;
                visited[row][col + 1] = false;
            }

        }
        dfs(index + 1, sum);
    }

    static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1][m + 1];
        map = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        answer = 0;
    }
}
