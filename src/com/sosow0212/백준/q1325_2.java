package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1325_2 {

    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[n + 1];

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i : answer) {
            max = Math.max(max, i);
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    static void bfs(final int node) {
        visited[node] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer next : list[now]) {
                if (!visited[next]) {
                    q.add(next);
                    answer[next]++;
                    visited[next] = true;
                }
            }
        }
    }
}
