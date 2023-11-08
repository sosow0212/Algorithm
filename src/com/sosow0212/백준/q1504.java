package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q1504 {

    static final int MAX = 200_000_000;
    static int n;
    static int e;
    static ArrayList<Node>[] list;
    static int v1;
    static int v2;
    static boolean[] visited;
    static int[] dp;

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
        e = sc.nextInt();

        list = new ArrayList[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, MAX);

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        v1 = sc.nextInt();
        v2 = sc.nextInt();

        int answer1 = bfs(1, v1) + bfs(v1, v2) + bfs(v2, n);
        int answer2 = bfs(1, v2) + bfs(v2, v1) + bfs(v1, n);

        if (answer1 >= MAX && answer2 >= MAX) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(answer1, answer2));
    }

    static int bfs(int start, int end) {
        visited = new boolean[n + 1];
        Arrays.fill(dp, MAX);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dp[start] = 0;

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
