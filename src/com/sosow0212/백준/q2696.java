package com.sosow0212.백준;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q2696 {

    static final Scanner sc = new Scanner(System.in);
    static final StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) {
        int t = sc.nextInt();
        count = 0;

        for (int i = 0; i < t; i++) {
            solve();
        }

        System.out.println(sb);
    }

    static void solve() {
        int n = sc.nextInt();
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();
        sb.append((n + 1) / 2)
                .append("\n");

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();

            // 값 넣기
            if (min.size() == max.size()) {
                max.add(val);
            } else {
                min.add(val);
            }

            if (!max.isEmpty() && !min.isEmpty()) {
                if (min.peek() > max.peek()) {
                    int temp = max.poll();
                    max.add(min.poll());
                    min.add(temp);
                }
            }

            // 짝수인 경우 출력
            if (i % 2 == 0) {
                sb.append(max.peek()).append(" ");
                count++;

                if (count % 10 == 0) {
                    sb.append("\n");
                }
            }
        }

        sb.append("\n");
    }
}
