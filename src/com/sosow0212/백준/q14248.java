package com.sosow0212.백준;

import java.util.Scanner;

public class q14248 {

    private static int n;
    private static int start;
    private static int[] map;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            map[i] = sc.nextInt();
        }

        start = sc.nextInt();
    }

    private static void getAnswer() {
        dfs(start - 1);
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int start) {
        visited[start] = true;
        int moveCount = map[start];
        int nowIndex = start;

        int nextRight = nowIndex + moveCount;
        int nextLeft = nowIndex - moveCount;

        if (nextRight >= 0 && nextRight < n) {
            dfs(nextRight);
        }

        if (nextLeft >= 0 && nextLeft < n) {
            dfs(nextLeft);
        }
    }
}
