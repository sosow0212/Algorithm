package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q6118 {

    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dp = new int[n + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        dp[1] = 0;
        visited[1] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer next : list[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    dp[next] = dp[now] + 1;
                }
            }
        }

        int max = -1;
        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }

        int count = 0;
        for (int i : dp) {
            if (i == max) {
                count++;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                System.out.println(i + " " + dp[i] + " " + count);
                return;
            }
        }
    }
}
