package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1697 {
    static int n, k;
    static int[] visited;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new int[1000001];

        if (n == k)
            System.out.println(0);
        else {
            bfs(n);
        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if(next == k) {
                    // 도착할 경우
                    System.out.println(visited[temp]);
                    return;
                }

                if(next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[temp] + 1;
                }
            }
        }

    }
}
