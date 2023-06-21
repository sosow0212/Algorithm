package com.sosow0212.백준;

import java.util.Scanner;

public class q14712 {

    static int n, m;
    static int answer;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n + 1][m + 1];
        answer = 0;

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int index) {
        if (index == n * m) {
            answer++;
            return;
        }

        int row = index / m + 1;
        int col = index % m + 1;

        if (map[row - 1][col] == 1 && map[row][col - 1] == 1 && map[row - 1][col - 1] == 1) {
            dfs(index + 1);
        } else {
            dfs(index + 1);
            map[row][col] = 1;
            dfs(index + 1);
            map[row][col] = 0;
        }
    }
}
