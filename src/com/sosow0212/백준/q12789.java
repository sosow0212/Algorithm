package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class q12789 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> waits = new Stack<>();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        int order = 1;
        while (!queue.isEmpty()) {
            if (order == queue.peek()) {
                order++;
                queue.poll();
                continue;
            }

            if (!waits.isEmpty() && waits.peek() == order) {
                waits.pop();
                order++;
            } else {
                waits.push(queue.poll());
            }
        }

        boolean isNice = true;
        while (!waits.isEmpty()) {
            if (waits.peek() == order) {
                waits.pop();
                order++;
            } else {
                isNice = false;
                break;
            }
        }

        if (isNice) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
