package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class q947 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public int removeStones(int[][] stones) {
        int n = stones.length;
        list = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        System.out.println(Arrays.toString(list));

        int group = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                group++;
            }
        }

        return n - group;
    }

    static void dfs(int index) {
        visited[index] = true;

        for (Integer next : list[index]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        q947 sol = new q947();

        // 5
        System.out.println(sol.removeStones(new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        }));
    }
}
