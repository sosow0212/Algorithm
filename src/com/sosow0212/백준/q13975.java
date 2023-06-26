package com.sosow0212.백준;

import java.util.PriorityQueue;
import java.util.Scanner;

public class q13975 {

    private static final Scanner sc = new Scanner(System.in);

    private static long answer;

    public static void main(String[] args) {

        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            answer = 0;
            getAnswer();
            System.out.println(answer);
        }
    }

    private static void getAnswer() {
        int n = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextLong());
        }

        while (pq.size() > 1) {
            Long a = pq.poll();
            Long b = pq.poll();
            answer += a + b;
            pq.offer(a + b);
        }
    }
}
