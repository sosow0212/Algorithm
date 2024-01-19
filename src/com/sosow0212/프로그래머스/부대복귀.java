package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 부대복귀 {

    static ArrayList<Integer>[] list;
    static Map<Integer, Integer> dist;
    static int[] dp;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        list = new ArrayList[n + 1];
        dist = new HashMap<>();
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[destination] = 0;

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            dist.put(i, -1);
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];

            list[a].add(b);
            list[b].add(a);
        }

        bfs(destination, n);

        for (int i = 0; i < sources.length; i++) {
            if (dp[sources[i]] == Integer.MAX_VALUE) {
                dp[sources[i]] = -1;
            }

            answer[i] = dp[sources[i]];
        }

        return answer;
    }

    static void bfs(int node, int n) {
        boolean[] visited = new boolean[n + 1];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{node, 0});
        visited[node] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (Integer next : list[now[0]]) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                dp[next] = Math.min(dp[next], now[1] + 1);
                q.add(new int[]{next, now[1] + 1});
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                5,
                new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}},
                new int[]{1, 3, 5},
                5
        )));
    }
}
