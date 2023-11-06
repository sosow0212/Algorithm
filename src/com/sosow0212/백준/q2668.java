package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class q2668 {

    static int n;
    static int start;
    static int[] arr;
    static List<Integer> answers;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n];
        arr = new int[n];
        answers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() - 1;
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            start = i;
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(answers);

        System.out.println(answers.size());
        for (Integer node : answers) {
            System.out.println(node + 1);
        }
    }

    public static void dfs(int i) {
        if (arr[i] == start) answers.add(start);

        if (!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i]);
            visited[arr[i]] = false;
        }
    }
}
