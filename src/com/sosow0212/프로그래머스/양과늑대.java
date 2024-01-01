package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 양과늑대 {

    static int[] infos;
    static int n;
    static ArrayList<Integer>[] graph;
    static int answer;

    public static int solution(int[] info, int[][] edges) {
        answer = 0;
        infos = info;
        n = info.length;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        List<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(next, 0, 0, 0);

        return answer;
    }

    static void dfs(List<Integer> list, int index, int sheep, int wolf) {
        if (infos[index] == 0) {
            sheep += 1;
        } else {
            wolf += 1;
        }

        if (wolf >= sheep) {
            return;
        }

        answer = Math.max(sheep, answer);

        List<Integer> next = new ArrayList<>(list);

        if (!graph[index].isEmpty()) {
            next.addAll(graph[index]);
        }
        next.remove(Integer.valueOf(index));

        for (Integer node : next) {
            dfs(next, node, sheep, wolf);
        }
    }

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}};

        // 5
        System.out.println(solution(info, edges));
    }
}
