package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int max;
    static int[] dp;

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        max = Integer.MIN_VALUE;
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int[] linkedVertex = edge[i];
            list[linkedVertex[0]].add(linkedVertex[1]);
            list[linkedVertex[1]].add(linkedVertex[0]);
        }

        dp[1] = 0;
        bfs(1);

        max = Arrays.stream(dp)
                .max()
                .getAsInt();

        return (int) Arrays.stream(dp)
                .filter(it -> it == max)
                .count();
    }

    static void bfs(int start) {
        visited[start] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Integer now = q.poll();
            ArrayList<Integer> linked = list[now];

            for (Integer next : linked) {
                if (!visited[next]) {
                    q.add(next);
                    dp[next] = dp[now] + 1;
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        // 3
        System.out.println(solution(n, edge));
    }
}
