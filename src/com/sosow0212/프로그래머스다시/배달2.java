package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 배달2 {

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int answer;
    static int[] value;

    public static int solution(int n, int[][] road, int k) {
        answer = 0;
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        value = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(value, Integer.MAX_VALUE);

        for (int[] r : road) {
            list[r[0]].add(new Node(r[0], r[1], r[2]));
            list[r[1]].add(new Node(r[1], r[0], r[2]));
        }

        bfs();
        for (int i : value) {
            if (i <= k) {
                answer++;
            }
        }

        return answer;
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.addAll(list[1]);
        visited[1] = true;
        value[1] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (value[now.start] <= value[now.end] + now.weight) {
                continue;
            }

            value[now.start] = value[now.end] + now.weight;
            q.addAll(list[now.start]);
        }
    }

    static class Node {

        int start;
        int end;
        int weight;

        public Node(final int start, final int end, final int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int k = 4;

        // 4
        System.out.println(solution(n, road, k));
    }
}
