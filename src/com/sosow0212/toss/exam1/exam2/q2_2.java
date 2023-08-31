package com.sosow0212.toss.exam1.exam2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q2_2 {

    static int answer;
    static List<Integer>[] map;
    static boolean[] visited;

    public int solution(int[][] relationships, int target, int limit) {
        answer = 0;
        map = new ArrayList[101];
        visited = new boolean[101];

        for (int i = 1; i < 101; i++) {
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

    private static void bfs(int target, int limit) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{target, 0});
        visited[target] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int person = now[0];
            int link = now[1];

            if (link >= 2 && link <= limit) {
                answer += 11;
            } else if (link == 1) {
                answer += 5;
            } else if (link > limit) {
                continue;
            }

            for (int friend : map[person]) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    q.offer(new int[]{friend, link + 1});
                }
            }
        }
    }

    public static void main(String[] args) {
        q2_2 sol = new q2_2();

        int[][] relationships = {{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}};
        int target = 2;
        int limit = 3;

        // 37
        System.out.println(sol.solution(relationships, target, limit));
    }
}
