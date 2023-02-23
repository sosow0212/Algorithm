package com.sosow0212.백준;

import java.util.Scanner;

public class q1956 {

    static int[][] road;
    static int v, e;
    static int answer;
    static final int INF = 10000000;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void getAnswer() {
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    road[j][k] = Math.min(road[j][k], road[j][i] + road[i][k]);
                }
            }
        }

        boolean check = false;

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j && road[i][j] != INF && road[j][i] != INF) {
                    answer = Math.min(road[i][j] + road[j][i], answer);
                    check = true;
                }
            }
        }

        System.out.println(check ? answer : -1);
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        road = new int[v + 1][v + 1];

        answer = INF;

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    road[i][j] = 0;
                } else {
                    road[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int val = sc.nextInt();

            road[from][to] = val;
        }
    }
}
