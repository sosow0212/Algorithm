package com.sosow0212.woowa_study.set2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class q13975 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            pq.add(num);
        }

        int answer = 0;
        while (pq.size() > 1) {
            long sum = pq.poll() + pq.poll();
            answer += sum;
            pq.add(sum);
        }

        System.out.println(answer);
    }
}
