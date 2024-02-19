package com.sosow0212.백준;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class q2346 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Deque<int[]> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        sb.append("1 ");
        int moveCount = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            dq.add(new int[]{i, sc.nextInt()});
        }

        while (!dq.isEmpty()) {
            if (moveCount > 0) {
                for (int i = 0; i < moveCount - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
                int[] next = dq.pollFirst();
                moveCount = next[1];
                sb.append(next[0])
                        .append(" ");
            } else {
                for (int i = 0; i < Math.abs(moveCount) - 1; i++) {
                    dq.addFirst(dq.pollLast());
                }

                int[] next = dq.pollLast();
                moveCount = next[1];
                sb.append(next[0])
                        .append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
