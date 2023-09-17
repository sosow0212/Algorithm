package com.sosow0212.woowa_study.set1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1939 {

    private static ArrayList<Node>[] graph;
    private static int n, m;
    private static int max;
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList[n + 1];
        max = 0;
        answer = 0;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();

            graph[s].add(new Node(e, v));
            graph[e].add(new Node(s, v));
            max = Math.max(max, v);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        getAnswer(a, b);
        System.out.println(answer);
    }

    static void getAnswer(int a, int b) {
        int left = 1;
        int right = max;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            q.add(a);
            visited[a] = true;

            if (isExistRoute(q, visited, m, b)) {
                answer = Math.max(mid, answer);
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            q = new LinkedList<>();
            visited = new boolean[n + 1];
        }
    }

    static boolean isExistRoute(Queue<Integer> q, boolean[] visited, int mid, int end) {
        while (!q.isEmpty()) {
            Integer start = q.poll();

            for (Node node : graph[start]) {
                if (node.val >= mid) {
                    if (start == end) {
                        return true;
                    }
                }

                if (!visited[node.end]) {
                    visited[node.end] = true;
                    q.add(node.end);
                }

            }
        }

        return false;
    }

    static class Node {

        int end;
        int val;

        public Node(final int end, final int val) {
            this.end = end;
            this.val = val;
        }
    }
}
