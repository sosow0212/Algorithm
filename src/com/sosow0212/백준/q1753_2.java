package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q1753_2 {

    static ArrayList<Node>[] list;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(final int end, final int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(final Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        list = new ArrayList[vertex + 1];
        int[] dist = new int[vertex + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < vertex + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            list[u].add(new Node(v, w));
        }

        bfs(vertex, dist, start);

        for (int i = 1; i < vertex + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }

            System.out.println(dist[i]);
        }
    }

    private static void bfs(final int vertex, final int[] dist, final int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[vertex + 1];
        dist[start] = 0;
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            int endNodeIndex = now.end;

            if (visited[endNodeIndex]) {
                continue;
            }

            visited[endNodeIndex] = true;

            for (Node node : list[endNodeIndex]) {
                if (!visited[node.end] && dist[node.end] > (dist[endNodeIndex] + node.weight)) {
                    dist[node.end] = dist[endNodeIndex] + node.weight;
                    q.offer(new Node(node.end, dist[node.weight]));
                }
            }
        }
    }
}
