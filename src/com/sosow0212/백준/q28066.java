package com.sosow0212.백준;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class q28066 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        int answer = -1;
        while (true) {
            if (dq.size() < k) {
                answer = dq.peek();
                break;
            }

            for (int i = 0; i < k; i++) {
                dq.add(dq.pollFirst());
            }

            for (int i = 0; i < k - 1; i++) {
                dq.pollLast();
            }
        }

        System.out.println(answer);

//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            list.add(i);
//        }
//
//        int answer = 0;
//        while (true) {
//            if (list.size() < k) {
//                answer = list.get(0);
//                break;
//            }
//
//            for (int i = 0; i < k - 1; i++) {
//                list.remove(1);
//            }
//
//            List<Integer> tails = list.subList(1, list.size());
//            tails.add(list.get(0));
//
//            list = tails;
//        }
//
//        System.out.println(answer);
    }
}
