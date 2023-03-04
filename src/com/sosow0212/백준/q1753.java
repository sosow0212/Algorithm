package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class q1753 {

    private static int v, e;
    private static int k;
    private static int[] moveWeight;
    private static boolean[] visited;
    private static List<Edge>[] map;

    static class Edge {
        int destination;
        int weight;

        public Edge(final int destination, final int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        initData();
        dijkstra();
        getAnswer();
    }

    private static void initData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        visited = new boolean[v + 1];
        moveWeight = new int[v + 1];
        map = new List[v + 1];

        for (int i = 1; i <= v; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[start].add(new Edge(dist, weight));
        }

        Arrays.fill(moveWeight, Integer.MAX_VALUE);
        moveWeight[k] = 0;
    }

    private static void dijkstra() {
        for (int i = 1; i <= v; i++) {
            int minMoveWeightValue = Integer.MAX_VALUE;
            int indexOfMinMoveWeightValue = -1;

            for (int j = 1; j <= v; j++) {
                if (moveWeight[j] < minMoveWeightValue && !visited[j]) {
                    minMoveWeightValue = moveWeight[j];
                    indexOfMinMoveWeightValue = j;
                }
            }

            if (indexOfMinMoveWeightValue == -1) {
                break;
            }

            for (Edge next : map[indexOfMinMoveWeightValue]) {
                if (!visited[next.destination] && moveWeight[indexOfMinMoveWeightValue] + next.weight < moveWeight[next.destination]) {
                    moveWeight[next.destination] = moveWeight[indexOfMinMoveWeightValue] + next.weight;
                }
            }

            visited[indexOfMinMoveWeightValue] = true;
        }
    }

    private static void getAnswer() {
        for (int i = 1; i <= v; i++) {
            if (moveWeight[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(moveWeight[i]);
        }
    }
}
