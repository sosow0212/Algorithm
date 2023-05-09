package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q1967 {

    private static List<Node>[] list;
    private static boolean[] visited;
    private static int answer, n;

    public static void main(String[] args) throws IOException {
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

    private static void initData() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        list = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, val));
            list[child].add(new Node(parent, val));
        }

        answer = 0;
    }

    private static class Node {
        int index;
        int value;

        public Node(final int index, final int value) {
            this.index = index;
            this.value = value;
        }
    }
}
