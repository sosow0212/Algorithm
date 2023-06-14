package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q16928 {

    static int[] trap;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) {
        initData();
        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        count[1] = 0;
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == 100) {
                System.out.println(count[now]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next > 100 || visited[next]) {
                    continue;
                }

                visited[next] = true;

                if (trap[next] != 0) {
                    if (!visited[trap[next]]) {
                        q.offer(trap[next]);
                        visited[trap[next]] = true;
                        count[trap[next]] = count[now] + 1;
                    }
                    continue;
                }

                q.offer(next);
                count[next] = count[now] + 1;
            }
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        trap = new int[101];
        count = new int[101];
        visited = new boolean[101];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            trap[start] = end;
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            trap[start] = end;
        }
    }
}
