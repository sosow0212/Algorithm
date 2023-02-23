package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q1389 {

    private static int n, m;
    private static List<Integer>[] list;
    private static int[] dist;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dist = new int[n + 1];
        list = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            list[node1].add(node2);
            list[node2].add(node1);
        }
    }

    private static void getAnswer() {
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 1; i <= n; i++) {
            int value = bfs(i);
            if (value < minValue) {
                minValue = value;
                minIndex = i;
            }
        }

        System.out.println(minIndex);
    }

    private static int bfs(int index) {
        Arrays.fill(dist, -1);
        dist[index] = 0;

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);

        while (!queue.isEmpty()) {
            int node1 = queue.poll();
            for (int node2 : list[node1]) {
                if (dist[node2] != -1) {
                    continue;
                }

                dist[node2] = dist[node1] + 1;
                count += dist[node2];
                queue.add(node2);
            }
        }

        return count;
    }
}
