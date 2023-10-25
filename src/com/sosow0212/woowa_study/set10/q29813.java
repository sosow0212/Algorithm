package com.sosow0212.woowa_study.set10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class q29813 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> map = new LinkedHashMap<>();
        Deque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int number = sc.nextInt();

            map.put(name, number);
            deque.addLast(name);
        }

        while (deque.size() != 1) {
            String target = deque.pollFirst();
            Integer targetNumber = map.get(target);

            for (int i = 0; i < targetNumber - 1; i++) {
                String next = deque.poll();
                deque.addLast(next);
            }

            deque.poll();
        }

        System.out.println(deque.getFirst());
    }
}
