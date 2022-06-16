package com.sosow0212.백준;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        int count = 0;
        int num = 0;

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        while (!queue.isEmpty()) {
            if (count % 2 == 0)
                num = queue.poll();
            else {
                num += queue.poll();
                queue.add(num);
                sum += num;
            }
            count++;
        }

        System.out.println(sum);
    }
}

// 10 20 30 40
// (10+20) + (30+30) + (60 + 40)