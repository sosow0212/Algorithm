package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1697_2 {

    private static final int MAX_DISTANCE = 1000001;
    private static final int MINIMUM_DISTANCE = 0;

    static int n, k;
    static int time[];
    static int answer;

    public static void main(String[] args) {
        initData();
        getAnswer(n);
        System.out.println(n == k ? 0 : time[k] - 1);
    }

    static void getAnswer(int position) {
        Queue<Integer> q = new LinkedList<>();
        q.add(position);
        time[position] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 3; i++) {
                int next = -1;

                if (i == 0) {
                    next = now + 1;
                } else if (i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }

                if (next >= MINIMUM_DISTANCE && next < MAX_DISTANCE && time[next] == 0) {
                    q.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        time = new int[MAX_DISTANCE];
        answer = 0;
    }
}
