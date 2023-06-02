package com.sosow0212.study;

import java.util.LinkedList;
import java.util.Scanner;

public class Self {
    private static LinkedList<Integer>[] graph;
    private static boolean[] visited;
    private static int n;
    private static int link;
    private static int answer = -1;

    public static void main(String[] args) {
        initData();
        System.out.println(answer);
    }

    // 추후에 initData 어떻게 처리할지 고민하기
    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        link = sc.nextInt();
        graph = new LinkedList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < link; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        dfs(1);
        for(boolean b : visited) {
            System.out.println(b);
            if(b) {
                answer ++;
            }
        }
    }

    private static void dfs(int index) {
        visited[index] = true;

        for(int node : graph[index]) {
            if(!visited[node]) {
                dfs(node);
            }
        }
    }
}
