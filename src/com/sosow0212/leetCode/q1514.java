package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class q1514 {

    private static Map<Integer, List<int[]>> map;
    private static double[] probs;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        map = new HashMap<>();
        probs = new double[n];
        probs[start] = 1.0;

        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int d = edges[i][1];
            map.computeIfAbsent(s, x -> new ArrayList<>()).add(new int[]{d, i});
            map.computeIfAbsent(d, x -> new ArrayList<>()).add(new int[]{s, i});
        }

        return bfs(succProb, start, end);
    }

    private double bfs(final double[] succProb, final int start, final int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int[] neighbor : map.getOrDefault(current, new ArrayList<>())) {
                int next = neighbor[0];
                int i = neighbor[1];
                double newProb = probs[current] * succProb[i];

                if (newProb > probs[next]) {
                    probs[next] = newProb;
                    queue.offer(next);
                }
            }
        }

        return probs[end];
    }

    public static void main(String[] args) {
        q1514 sol = new q1514();

        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};

        // 0.25
        System.out.println(sol.maxProbability(n, edges, succProb, 0, 2));
    }
}
