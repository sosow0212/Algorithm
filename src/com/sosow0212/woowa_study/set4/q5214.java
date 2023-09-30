package com.sosow0212.woowa_study.set4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q5214 {

    static int n;
    static int k;
    static int m;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 17);
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + m + 2];
        visited = new boolean[n + m + 2];

        for (int i = 1; i <= n + m + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int hyper = n + i;
            for (int j = 1; j <= k; j++) {
                int val = Integer.parseInt(st.nextToken());
                list[hyper].add(val);
                list[val].add(hyper);
            }
        }

        bfs(1);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        q.add(0);

        boolean checked = false;
        while (!q.isEmpty()) {
            Integer startPoint = q.poll(); // 1
            Integer distValue = q.poll(); // 0

            if (startPoint == n) {
                System.out.println((distValue / 2) + 1);
                checked = true;
                break;
            }

            for (Integer next : list[startPoint]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    q.add(distValue + 1);
                }
            }
        }

        if (!checked) {
            System.out.println(-1);
        }
    }
}
