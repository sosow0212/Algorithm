package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q5972 {

    static final int INF = 50000 * 1000;

    static int n;
    static int m;
    static ArrayList<Node>[] list;
    static int[] dp;
    static boolean[] visited;

    static class Node implements Comparable<Node> {

        int end;
        int weight;

        public Node(final int end, final int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(final Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        dp = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        int answer = bfs(1, n);

        System.out.println(answer);
    }

    static int bfs(int start, int end) {
        Arrays.fill(dp, INF);
        dp[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;

            for (Node next : list[now.end]) {
                if (dp[next.end] > now.weight + next.weight) {
                    dp[next.end] = now.weight + next.weight;
                    q.add(new Node(next.end, dp[next.end]));
                }
            }
        }

        return dp[end];
    }
}
