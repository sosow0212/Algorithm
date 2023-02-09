package com.sosow0212.study;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph2606 {
    private static LinkedList<Integer>[] graph;
    private static boolean[] visited;
    private static int answer = 0;
    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new LinkedList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        dfs(1);
        System.out.println(answer);

        for (boolean b : visited) {
            if(b) {
                answer ++;
            }
        }

        System.out.println(answer - 1); // 1에게 걸린 바이러스이므로 1은 제외시켜준다.
    }

    private static void dfs(int index) {
        visited[index] = true;

        for (int node : graph[index]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}
