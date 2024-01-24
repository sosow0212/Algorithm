package com.sosow0212.백준;

import java.util.Scanner;

public class q7511 {

    static final Scanner sc = new Scanner(System.in);
    static StringBuilder sb;

    static int[] parent;

    public static void main(String[] args) {
        int t = sc.nextInt();
        sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            solve(i + 1);
        }

        System.out.println(sb.toString());
    }

    static void solve(int t) {
        int n = sc.nextInt(); // 유저 수
        int k = sc.nextInt(); // 친구 관계의 수
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 친구 맺음
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            union(a, b);
        }

        int m = sc.nextInt(); // 구할 쌍의 수

        sb.append("Scenario " + t + ":").append("\n");
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (find(a) == find(b)) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }

        }
        sb.append("\n");
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            if (px < py) {
                parent[y] = px;
            } else {
                parent[x] = py;
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }
}
