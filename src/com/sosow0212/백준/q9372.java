package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q9372 {
    static int N, M, result;
    static boolean visit[];
    static int arr[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;

            arr = new int[N + 1][N + 1];
            visit = new boolean[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u][v] = 1;
                arr[v][u] = 1;
            }
            bfs();
            System.out.println(result - 1);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()) {
            result++;
            int val = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[val][i] != 0 && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}