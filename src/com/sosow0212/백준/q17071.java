package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17071 {
    static int N;
    static int K;
    static int[] target;
    static int minResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        minResult = Integer.MAX_VALUE;
        target = new int[500001];
        Arrays.fill(target, -1);

        int time = 0;
        while (K + (time * (time + 1) / 2) < 500001) {
            target[K + (time * (time + 1) / 2)] = time;
            time++;
        }

        bfs();

        if (minResult == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minResult);

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[500001][2];

        queue.offer(new int[]{N, 0});
        visited[N][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int time = cur[1];

            if (target[x] != -1 && target[x] % 2 == time % 2 && time <= target[x])
                minResult = Math.min(minResult, target[x]);

            if (x + 1 < 500001 && !visited[x + 1][(time + 1) % 2]) {
                queue.offer(new int[]{x + 1, time + 1});
                visited[x + 1][(time + 1) % 2] = true;
            }
            if (x - 1 >= 0 && !visited[x - 1][(time + 1) % 2]) {
                queue.offer(new int[]{x - 1, time + 1});
                visited[x - 1][(time + 1) % 2] = true;
            }
            if (x * 2 < 500001 && !visited[x * 2][(time + 1) % 2]) {
                queue.offer(new int[]{x * 2, time + 1});
                visited[x * 2][(time + 1) % 2] = true;
            }
        }
    }
}
