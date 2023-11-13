package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class q11779 {

    static final int INF = 1000 * 100000;

    static int n;
    static int m;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dp;
    static int[] pre;
    static int start;
    static int end;

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

        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        dp = new int[n + 1];
        pre = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int next = sc.nextInt();
            int weight = sc.nextInt();

            list[start].add(new Node(next, weight));
        }

        start = sc.nextInt();
        end = sc.nextInt();

        System.out.println(bfs(start));

        Stack<Integer> order = new Stack<>();
        order.push(end);
        while (true) {
            end = pre[order.peek()];

            if (end == 0) {
                break;
            }

            order.push(end);
        }

        System.out.println(order.size());

        while (!order.isEmpty()) {
            System.out.print(order.pop() + " ");
        }
    }

    static int bfs(int start) {
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
                if (dp[next.end] > dp[now.end] + next.weight) {
                    dp[next.end] = dp[now.end] + next.weight;
                    pre[next.end] = now.end;
                    q.add(new Node(next.end, dp[next.end]));
                }
            }
        }

        return dp[end];
    }
}
