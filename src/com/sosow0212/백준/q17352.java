package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q17352 {

    static int n;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n - 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            union(a, b);
        }

        System.out.println(Arrays.toString(parent));

        for (int i = 2; i <= n; i++) {
            if (find(parent[1]) != find(parent[i])) {
                System.out.println(1 + " " + i);
                return;
            }
        }
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

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
