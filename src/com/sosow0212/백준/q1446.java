package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class q1446 {

    static class Road implements Comparator<Road> {
        int start;
        int end;
        int weight;

        public Road(final int start, final int end, final int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compare(final Road o1, final Road o2) {
            if (o1.start < o2.start) {
                return -1;
            }

            return 1;
        }

        @Override
        public String toString() {
            return this.start + " " + this.end + " " + this.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        List<Road> roads = new ArrayList<>();
        int[] dp = new int[10001];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int shortcut = sc.nextInt();

            if (end > d || end - start <= shortcut) {
                continue;
            }

            roads.add(new Road(start, end, shortcut));
        }

        for (int now = 1; now <= d; now++) {

            for (Road road : roads) {
                if (road.end == now) {
                    int shortcut = Math.min(
                            dp[now - 1] + 1,
                            dp[road.start] + road.weight
                    );

                    dp[now] = Math.min(dp[now], shortcut);
                }
            }

            dp[now] = Math.min(dp[now], dp[now - 1] + 1);
        }

        System.out.println(dp[d]);
    }
}
