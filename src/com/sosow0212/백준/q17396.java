package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q17396 {

    static final long INF = Long.MAX_VALUE;
    static int n;
    static int m;
    static int[] wad;
    static ArrayList<Node>[] list;
    static Long[] dp;
    static boolean[] visited;

    static class Node implements Comparable<Node> {

        int end;
        long weight;

        public Node(final int end, final long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(final Node o) {
            return (int) (this.weight - o.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n];
        dp = new Long[n];
        visited = new boolean[n];
        wad = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            wad[i] = sc.nextInt();
        }
        wad[n - 1] = 0;

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        long answer = bfs(0, n - 1);
        if (answer == INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    static long bfs(int start, int end) {
        Arrays.fill(dp, INF);
        dp[start] = 0L;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (visited[now.end] || wad[now.end] == 1) {
                continue;
            }

            visited[now.end] = true;

            for (Node next : list[now.end]) {
                if (dp[next.end] > now.weight + next.weight) {
                    dp[next.end] = (long) (now.weight + next.weight);
                    q.add(new Node(next.end, dp[next.end]));
                }
            }
        }

        return dp[end];
    }
}
