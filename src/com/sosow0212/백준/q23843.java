package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q23843 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        list.sort(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int charge : list) {
            if (pq.size() < m) {
                pq.add(charge);
            } else {
                int outcome = pq.poll();
                pq.add(outcome + charge);
            }
        }

        int maxTime = 0;
        while (!pq.isEmpty()) {
            maxTime = Math.max(maxTime, pq.poll());
        }

        System.out.println(maxTime);
    }
}
