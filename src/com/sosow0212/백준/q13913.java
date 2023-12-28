package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class q13913 {

    static final int LIMIT = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] time = new int[LIMIT];
        int[] parent = new int[LIMIT];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n] = 1;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            if (now == k) {
                break;
            }

            if (now + 1 < LIMIT && time[now + 1] == 0) {
                time[now + 1] = time[now] + 1;
                parent[now + 1] = now;
                q.add(now + 1);
            }

            if (now - 1 >= 0 && time[now - 1] == 0) {
                time[now - 1] = time[now] + 1;
                parent[now - 1] = now;
                q.add(now - 1);
            }

            if (now * 2 < LIMIT && time[now * 2] == 0) {
                time[now * 2] = time[now] + 1;
                parent[now * 2] = now;
                q.add(now * 2);
            }
        }

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }

        System.out.println(time[k] - 1);
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int index = k;
        while (true) {
            if (index == n) {
                break;
            }

            stack.push(parent[index]);
            index = parent[index];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop())
                    .append(" ");
        }

        System.out.println(sb);
    }
}
