package com.sosow0212.백준;

import java.util.PriorityQueue;
import java.util.Scanner;

public class q19598 {

    static class Node implements Comparable<Node> {

        int time;
        boolean isStart;

        public Node(final int time, final boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public String toString() {
            return this.time + " " + isStart;
        }

        @Override
        public int compareTo(final Node o) {
            return Integer.compare(time, o.time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(new Node(sc.nextInt(), true));
            pq.add(new Node(sc.nextInt(), false));
        }

        int room = 0;
        int answer = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            System.out.println(now.toString());

            if (now.isStart) {
                room++;
                answer = Math.max(answer, room);
            } else {
                room -= 1;
            }
        }

        System.out.println(answer);
    }
}
