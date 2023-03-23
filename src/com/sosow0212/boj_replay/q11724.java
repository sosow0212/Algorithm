package com.sosow0212.boj_replay;

import java.util.ArrayList;
import java.util.Scanner;

public class q11724 {

    private static int n, m;
    private static ArrayList<Integer>[] list;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            list[node1].add(node2);
            list[node2].add(node1);
        }
    }

    private static void getAnswer() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (Integer val : list[node]) {
            if (!visited[val]) {
                dfs(val);
            }
        }

    }
}
