package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q1717 {

    private static final int UNION_OPERATION = 0;

    static int n;
    static int m;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            int from = sc.nextInt();
            int to = sc.nextInt();

            int fromParent = findParent(from);
            int toParent = findParent(to);

            if (op == UNION_OPERATION) {
                if (fromParent == toParent) {
                    continue;
                }

                if (fromParent < toParent) {
                    parent[toParent] = fromParent;
                } else {
                    parent[fromParent] = toParent;
                }

            } else {
                if (fromParent == toParent) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        System.out.println(Arrays.toString(parent));
    }

    static int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        return findParent(parent[node]);
    }
}
