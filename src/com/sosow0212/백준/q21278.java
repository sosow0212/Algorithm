package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class q21278 {

    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int storeA;
    static int storeB;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        storeA = 0;
        storeB = 0;
        answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        permutation(0, 1, new int[2]);

        System.out.println(storeA + " " + storeB + " " + answer);
    }

    static void permutation(int index, int start, int[] store) {
        if (index == 2) {
            getAnswer(store);
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                store[index] = i;

                permutation(index + 1, start + 1, store);

                store[index] = 0;
                visited[i] = false;
            }
        }
    }

    static void getAnswer(int[] store) {
        int a = store[0];
        int b = store[1];

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n + 1];
        distance[a] = 0;
        visited[a] = true;
        getDistance(0, a, visited, distance);

        visited = new boolean[n + 1];
        distance[b] = 0;
        visited[b] = true;
        getDistance(0, b, visited, distance);

        int temp = 0;
        for (int i = 1; i < distance.length; i++) {
            temp += (distance[i] * 2);
        }

        if (temp < answer) {
            answer = temp;
            storeA = a;
            storeB = b;
        }
    }

    static void getDistance(int index, int store, boolean[] visited, int[] distance) {
        for (Integer i : list[store]) {
            if (!visited[i]) {
                visited[i] = true;
                distance[i] = Math.min(distance[i], index + 1);
                getDistance(index + 1, i, visited, distance);
            }
        }
    }
}
