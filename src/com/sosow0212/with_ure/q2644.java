package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q2644 {

    static int n;
    static int m;
    static int x;
    static int y;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        m = sc.nextInt();
        int answer = -1;

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int sun = sc.nextInt();
            list[sun].add(parent);
            list[parent].add(sun);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 1});
        boolean[] visited = new boolean[n + 1];
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (Integer i : list[now[0]]) {
                if (i == y) {
                    answer = now[1];
                }

                if (!visited[i]) {
                    visited[i] = true;
                    q.add(new int[]{i, now[1] + 1});
                }
            }
        }

        System.out.println(answer);
    }
}
