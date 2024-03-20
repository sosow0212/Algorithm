package com.sosow0212.woowa_study.set10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q29813_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();

        Deque<String> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String initial = sc.next();
            int nums = sc.nextInt();
            map.put(initial, nums);
            dq.add(initial);
        }

        while (dq.size() != 1) {
            String target = dq.pollFirst();
            int targetPoint = map.get(target) - 1;

            for (int i = 0; i < targetPoint; i++) {
                dq.addLast(dq.pollFirst());
            }

            dq.pollFirst();
        }

        System.out.println(dq.pollFirst());
    }
}
