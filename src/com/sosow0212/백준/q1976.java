package com.sosow0212.백준;

import java.util.Scanner;

public class q1976 {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int linked = sc.nextInt();

                if (linked == 1) {
                    union(i, j);
                }
            }
        }

        int start = find(sc.nextInt());
        for (int i = 1; i < m; i++) {
            int now = sc.nextInt();

            if (start != find(now)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}
