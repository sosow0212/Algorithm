package com.sosow0212.백준;

import java.util.Scanner;

public class q20040 {

    static int n;
    static int m;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (find(a) == find(b)) {
                System.out.println(i + 1);
                return;
            }

            union(find(a), find(b));
        }

        System.out.println(0);
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return find(parent[x]);
    }

    static void union(int x, int y) {
        if (x != y) {
            if (x < y) {
                parent[y] = parent[x];
            } else {
                parent[x] = parent[y];
            }
        }
    }

    static void find() {

    }
}
