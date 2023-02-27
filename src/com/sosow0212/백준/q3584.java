package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q3584 {

    private static final Scanner sc = new Scanner(System.in);
    private static int n;
    private static List<Integer>[] list;
    private static boolean visited[];
    private static int answer = 0;
    private static int findA, findB;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        n = sc.nextInt();
        list = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            list[node1].add(node2);
            list[node2].add(node1);
        }

        findA = sc.nextInt();
        findB = sc.nextInt();
    }

    private static void getAnswer() {
        dfs(16);
        dfs(7);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
        System.out.println(answer);
    }

    private static void dfs(int node) {
        if (visited[node] == true) {
            answer = node;
            return;
        }

        visited[node] = true;
        for (int val : list[node]) {
            if (!visited[val] && list[node].size() < list[val].size()) {
                dfs(val);
            }
        }
    }
}
