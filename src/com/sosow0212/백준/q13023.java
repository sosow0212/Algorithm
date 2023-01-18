package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Scanner;

public class q13023 {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m;
    private static int answer = 0;
    private static ArrayList<Integer>[] list;
    private static boolean[] visited;

    public static void main(String[] args) {
        initData();
        setupGraph();
        findAnswer();
    }

    private static void initData() {
        n = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
    }

    private static void setupGraph() {
        for (int i = 0; i < m; i++) {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            list[vertex1].add(vertex2);
            list[vertex2].add(vertex1);
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < n; i++) {
            if (answer == 0) {
                dfs(i, 1);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int start, int depth) {
        if (depth == 5) {
            answer = 1;
            return;
        }

        visited[start] = true;

        for (int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }

        visited[start] = false;
    }
}
