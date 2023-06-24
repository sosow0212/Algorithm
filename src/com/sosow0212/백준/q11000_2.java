package com.sosow0212.백준;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q11000_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] classes = new int[n][2];

        for (int i = 0; i < classes.length; i++) {
            classes[i][0] = sc.nextInt();
            classes[i][1] = sc.nextInt();
        }

        Arrays.sort(classes, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(classes[0][1]);
        for (int i = 1; i < n; i++) {
            if (classes[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(classes[i][1]);
        }

        System.out.println(pq.size());
    }
}
