package com.sosow0212.toss.exam1.exam2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class q2 {

    static int answer;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static int solution(int[][] relationships, int target, int limit) {
        answer = 0;
        list = new ArrayList[101];
        visited = new boolean[101];

        for (int i = 0; i < 101; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] relationship : relationships) {
            int a = relationship[0];
            int b = relationship[1];

            list[a].add(b);
            list[b].add(a);
        }

        answer = bfs(target, limit);

        return answer;
    }

    static int bfs(int target, int limit) {
        Queue<int[]> q = new LinkedList<>();
        visited[target] = true;
        q.add(new int[]{target, 0});
        int sum = 0;
        int plus = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int index = now[0];
            int depth = now[1];

            for (Integer next : list[index]) {
                if (depth >= limit) {
                    continue;
                }

                if (visited[next]) {
                    continue;
                }

                q.add(new int[]{next, depth + 1});
                visited[next] = true;

                if (list[target].contains(next)) {
                    sum += 5;
                } else {
                    sum += 11;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] relationships = {{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}};
        int target = 2;
        int limit = 3;

        // 37
        System.out.println(solution(relationships, target, limit));
    }
}
