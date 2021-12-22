package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge {
    int y;
    int x;

    public Edge(int y, int x) {
        super();
        this.y = y;
        this.x = x;
    }

}

public class q9205 {
    static int t, n;
    static List<Edge> list;
    static int[][] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            n = sc.nextInt();
            list = new ArrayList<>();
            dist = new int[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                list.add(new Edge(y, x));
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    dist[i][j] = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);
                    if (dist[i][j] > 1000) {
                        dist[i][j] = -1;
                        dist[j][i] = -1;
                    }
                }
            }


            floyd();


            if (dist[0][n + 1] == -1) {
                System.out.println("sad");
            } else {
                System.out.println("happy");
            }
        }


    }

    private static void floyd() {
        for (int k = 0; k < n + 2; k++) {
            for (int i = 0; i < n + 2; i++) {
                if (k == i) continue;
                for (int j = 0; j < n + 2; j++) {
                    if (i == j || j == k) continue;
                    if (dist[i][k] == -1 || dist[k][j] == -1) continue;
                    dist[i][j] = 1;

                }
            }
        }

    }
}