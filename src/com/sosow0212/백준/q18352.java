package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q18352 {

    static int n;
    static int m;
    static int k;
    static int x;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        bfs(x);

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == k) {
                answer.add(i);
            }
        }

        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (Integer i : answer) {
                System.out.print(i + " ");
            }
        }
    }

    static void bfs(int startNode) {
        dp[startNode] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer next : list[now]) {
                if (dp[next] == Integer.MAX_VALUE) {
                    dp[next] = dp[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
