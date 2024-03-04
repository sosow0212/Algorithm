package com.sosow0212.woowa_study.set2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class q13975_2 {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }

        long answer = 0;

        /**
         * 30, 30, 40
         * 60, 60+40 = 100
         */

        while (pq.size() >= 2) {
            long first = pq.poll();
            long second = pq.poll();
            long sum = first + second;

            answer += sum;
            pq.add(sum);
        }

        System.out.println(answer);
    }
}
