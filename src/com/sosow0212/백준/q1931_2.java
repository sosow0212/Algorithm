package com.sosow0212.백준;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q1931_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            pq.add(new int[]{start, end});
        }

        int answer = 0;
        int beforeEndTime = -1;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int start = now[0];
            int end = now[1];

            if (beforeEndTime <= end && beforeEndTime <= start) {
                beforeEndTime = end;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
