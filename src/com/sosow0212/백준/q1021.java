package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Scanner;

public class q1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> deque = new LinkedList<Integer>();

        int answer = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int target = deque.indexOf(arr[i]);
            int h;
            if (deque.size() % 2 == 0) {
                h = deque.size() / 2 - 1;
            } else {
                h = deque.size() / 2;
            }


            if (target <= h) {
                for (int j = 0; j < target; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    answer++;
                }
            } else {
                for (int j = 0; j < deque.size() - target; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    answer++;
                }

            }
            deque.pollFirst();
        }

        System.out.println(answer);

    }
}
