package com.sosow0212.exam.exam1.exam2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q2 {

    private int answer;
    private List<Integer>[] map;
    private boolean[] visited;

    public int solution(int[][] relationships, int target, int limit) {
        answer = 0;
        map = new ArrayList[relationships.length + 1];
        visited = new boolean[relationships.length + 1];

        for (int i = 1; i <= 100; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] relationship : relationships) {
            int node1 = relationship[0];
            int node2 = relationship[1];

            map[node1].add(node2);
            map[node2].add(node1);
        }

        bfs(target, limit);
        return answer;
    }

    private void bfs(int target, int limit) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{target, 0});
        visited[target] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int p = now[0];
            int value = now[1];

            if (value >= 2 && value <= limit) {
                answer += 11;
            } else if (value == 1) {
                answer += 5;
            } else if (value > limit) {
                continue;
            }

            for (int friend : map[p]) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    queue.offer(new int[]{friend, value + 1});
                }
            }
        }
    }

    public static void main(String[] args) {
        q2 sol = new q2();

        int[][] relationships = {{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}};
        int target = 2;
        int limit = 3;

        // 37
        System.out.println(sol.solution(relationships, target, limit));
    }
}
