package com.sosow0212.백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q13649_2 {

    static final int MAX = 15;

    static int n;
    static int k;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[MAX];
        answer = Integer.MAX_VALUE;
        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int index = now[0];
            int time = now[1];
            visited[index] = true;

            if (index == k) {
                answer = Math.min(answer, time);
            }

            if (index * 2 < MAX && !visited[index * 2]) {
                q.add(new int[]{index * 2, time});
            }

            if (index + 1 < MAX && !visited[index + 1]) {
                q.add(new int[]{index + 1, time + 1});
            }

            if (index - 1 >= 0 && !visited[index - 1]) {
                q.add(new int[]{index - 1, time + 1});
            }
        }
    }
}
