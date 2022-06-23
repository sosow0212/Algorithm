package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class q1922 {
    static int[] arr;

    static int search(int a) {
        if (a == arr[a])
            return a;
        return arr[a] = search(arr[a]);
    }

    static boolean union(int from, int to) {
        int a = search(from);
        int b = search(to);
        if (a != b) {
            arr[a] = b;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int network[][] = new int[m][3]; // 3

        for (int i = 0; i < m; i++) {
            network[i][0] = sc.nextInt();
            network[i][1] = sc.nextInt();
            network[i][2] = sc.nextInt();
        }

        // 비용으로 내림차순
        Arrays.sort(network, Comparator.comparing(o -> o[2]));

        int ans = 0;
        for (int[] nw : network) {
            if (union(nw[0], nw[1])) {
                ans += nw[2];
            }
        }

        System.out.println(ans);
    }
}
