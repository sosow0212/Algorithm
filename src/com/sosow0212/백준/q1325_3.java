package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1325_3 {

    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static Map<Integer, Integer> hacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        hacks = new HashMap<>();

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            list[start].add(end);
        }

        int max = -1;
        for (int i = 1; i <= n; i++) {
            int temp = bfs(i);
            max = Math.max(max, temp);
            hacks.put(i, temp);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : hacks.keySet()) {
            if (hacks.get(i) == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    static int bfs(int node) {
        int temp = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        boolean[] visited = new boolean[n + 1];
        visited[node] = true;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer i : list[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    temp++;
                }
            }
        }

        return temp;
    }
}
