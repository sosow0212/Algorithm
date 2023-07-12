package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q802 {

    static List<Integer> answer;
    static List<List<Integer>> list;
    static int[] terminals;
    static boolean[] visited;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        initData(graph);
        bfs(graph);

        for (int i = 0; i < graph.length; i++) {
            if (visited[i]) {
                answer.add(i);
            }
        }

        return answer;
    }

    private static void bfs(final int[][] graph) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (terminals[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;

            for (int next : list.get(now)) {
                terminals[next]--;
                if (terminals[next] == 0) {
                    // 0이면 다음이 큐에 들어가야함
                    q.add(next);
                }
            }
        }
    }

    private static void initData(final int[][] graph) {
        answer = new ArrayList<>();
        list = new ArrayList<>();
        visited = new boolean[graph.length];
        terminals = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int node : graph[i]) {
                list.get(node).add(i);
                terminals[i]++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        q802 sol = new q802();

        System.out.println(sol.eventualSafeNodes(graph));
    }
}
