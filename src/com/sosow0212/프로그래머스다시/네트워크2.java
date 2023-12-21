package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.List;

public class 네트워크2 {

    static List<Integer>[] list;
    static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (computers[i][j] == 1) {
                    list[i + 1].add(j + 1);
                    list[j + 1].add(i + 1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    static void dfs(int start) {
        visited[start] = true;
        List<Integer> now = list[start];

        if(now.size() == 0) {
            return;
        }

        for (Integer node : list[start]) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(node);
            }
        }
    }

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(3, computers)); // 2

        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(3, computers2)); // 1
    }
}
