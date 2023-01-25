package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q15686 {
    private static int n, m;
    private static int[][] map;
    private static List<int[]> house = new ArrayList<>();
    private static List<int[]> chicken = new ArrayList<>();
    private static List<int[]> choice = new ArrayList<>();
    private static int result = Integer.MAX_VALUE;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                }
                if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            int sum = 0;
            for (int[] h : house) {
                int min = Integer.MAX_VALUE;
                for (int[] c : choice) {
                    int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(d, min);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice.add(chicken.get(i));
                dfs(depth + 1, i + 1);
                choice.remove(choice.size() - 1);
                visited[i] = false;
            }
        }

    }
}
