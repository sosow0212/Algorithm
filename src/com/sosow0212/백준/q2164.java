package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q2164 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        // 1 2 3 4 5
        // 2 3 4 5

        while (q.size() > 1) {
            q.remove();
            Integer temp = q.poll();
            if (temp == null) {
                break;
            }
            q.add(temp);
        }

        System.out.println(q.poll());
    }
}
