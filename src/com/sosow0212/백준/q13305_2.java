package com.sosow0212.백준;

import java.util.PriorityQueue;
import java.util.Scanner;

public class q13305_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] need = new int[n - 1];
        int[] price = new int[n];

        for (int i = 0; i < n - 1; i++) {
            need[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();

        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            int liter = need[i];
            int nowPrice = price[i];

            pq.add((long) nowPrice);
            answer += pq.peek() * liter;
        }

        System.out.println(answer);
    }
}
