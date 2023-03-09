package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Scanner;

public class q13265 {

    private static final Scanner sc = new Scanner(System.in);

    private static int n, m, t;
    private static ArrayList<Integer>[] graph;
    private static int[] paints;
    private static boolean answer = true;

    public static void main(String[] args) throws Exception {
        t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            initData();
            getAnswer();
        }
    }

    private static void initData() {
        n = sc.nextInt();
        m = sc.nextInt();

        paints = new int[n + 1];
        graph = new ArrayList[n + 1];

        answer = true;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }
    }

    private static void getAnswer() {
        for (int i = 1; i <= n; i++) {
            if (paints[i] == 0) {
                paints[i] = 1;
                dfs(i);
            }
        }

        System.out.println(answer ? "possible" : "impossible");
    }

    public static void dfs(int node) {
        for (Integer next : graph[node]) {
            if (paints[next] == 0) {
                paints[next] = 3 - paints[node];
                dfs(next);
            }

            if (paints[node] == paints[next]) {
                answer = false;
                return;
            }
        }
    }
}
