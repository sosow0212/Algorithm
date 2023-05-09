package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1967_2 {

    private static int n, answer;
    private static List<Node>[] list;
    private static boolean[] visited;

    private static class Node {
        int index;
        int value;

        public Node(final int index, final int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void getAnswer() {
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    private static void dfs(int start, int sum) {
        for (Node node : list[start]) {
            if (!visited[node.index]) {
                visited[node.index] = true;
                dfs(node.index, sum + node.value);
            }
        }

        answer = Math.max(answer, sum);
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answer = 0;

        list = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int value = sc.nextInt();

            list[parent].add(new Node(child, value));
            list[child].add(new Node(parent, value));
        }
    }
}
