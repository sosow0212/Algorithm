package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망둘로나누기 {

    static int answer;
    static ArrayList<Integer>[] list;

    public static int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }

        for (int[] wire : wires) {
            int a = bfs(wire[0], wire[1], new boolean[n + 1]);
            int b = bfs(wire[1], wire[0], new boolean[n + 1]);
            answer = Math.min(answer, Math.abs(a - b));
        }

        return answer;
    }

    static int bfs(int me, int other, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(me);
        visited[me] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer node : list[now]) {
                if (!visited[node] && node != other) {
                    visited[node] = true;
                    q.add(node);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int n = 9;

        System.out.println(solution(n, wires)); // 3
    }
}
