package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 섬연결하기 {

    static int[] parent;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int val = cost[2];

            int fromParent = findParent(from);
            int toParent = findParent(to);

            if (fromParent == toParent) {
                continue;
            }

            answer += val;
            parent[toParent] = fromParent;
        }

        return answer;
    }

    static int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        // 4
        System.out.println(solution(n, costs));
    }
}
