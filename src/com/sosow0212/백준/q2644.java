package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q2644 {

    static int n, no1, no2;
    static int[][] map;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        no1 = sc.nextInt();
        no2 = sc.nextInt();

        map = new int[n + 1][n + 1];
        ans = new int[n + 1];

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }

        bfs(no1, no2);
        if (ans[no2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans[no2]);
        }
    }

    public static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();

            if (v == end) {
                break;
            }

            for (int i = 1; i <= n; i++) {
                if (map[v][i] == 1 && ans[i] == 0) {
                    ans[i] = ans[v] + 1;
                    q.add(i);
                }
            }
        }
    }
}
