package com.sosow0212.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) { // i < m이 아니야 임마
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j));
            }
            System.out.println();
        }

    }
}
