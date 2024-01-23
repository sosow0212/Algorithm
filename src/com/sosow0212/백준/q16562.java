package com.sosow0212.백준;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class q16562 {

    static int n;
    static int m;
    static int k;
    static int[] pay;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        pay = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            pay[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        int answer = 0;
        Set<Integer> p = new LinkedHashSet<>();
        for (int i = 1; i <= n; i++) {
            int indexOfParent = find(parent[i]);

            if (!p.contains(indexOfParent)) {
                answer += pay[indexOfParent];
                p.add(indexOfParent);
            }
        }

        if (answer <= k) {
            System.out.println(answer);
        } else {
            System.out.println("Oh no");
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (pay[x] < pay[y]) {
                parent[y] = parent[x];
            } else {
                parent[x] = parent[y];
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
