package com.sosow0212.프로그래머스;

import java.util.ArrayList;

public class 네트워크 {

    ArrayList<Integer>[] list;
    boolean visited[];
    int answer;

    public int solution(int n, int[][] computers) {
        initData(n, computers);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int node) {
        visited[node] = true;

        for (Integer val : list[node]) {
            if (!visited[val]) {
                dfs(val);
            }
        }
    }

    private void initData(final int n, final int[][] computers) {
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = 0;

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                if (computers[i][j] == 1) {
                    list[i + 1].add(j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        네트워크 sol = new 네트워크();

        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        // 2
        System.out.println(sol.solution(n, computers));

        // 1
        System.out.println(sol.solution(n, computers2));
    }
}
