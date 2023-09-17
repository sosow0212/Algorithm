package com.sosow0212.woowa_study.set1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q26215 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        if (pq.size() <= 1) {
            Integer number = pq.poll();
            if (number <= 1440) {
                System.out.println(number);
            } else {
                System.out.println(-1);
            }
            return;
        }

        while (!pq.isEmpty()) {
            if (pq.size() >= 2) {
                Integer a = pq.poll();
                Integer b = pq.poll();

                if (a - 1 != 0) {
                    pq.add(a - 1);
                }

                if (b - 1 != 0) {
                    pq.add(b - 1);
                }

                answer++;
            } else {
                Integer number = pq.poll();
                if (answer + number <= 1440) {
                    System.out.println(answer + number);
                } else {
                    System.out.println(-1);
                }
                return;
            }
        }

        System.out.println(answer);
    }
}
