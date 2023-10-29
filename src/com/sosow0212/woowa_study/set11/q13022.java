package com.sosow0212.woowa_study.set11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class q13022 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Map<Character, Integer> wordsCounter = new HashMap<>();
        Map<Character, Character> order = Map.of(
                'w', 'f',
                'o', 'w',
                'l', 'o',
                'f', 'l'
        );

        char before = s.charAt(0);
        wordsCounter.put(before, 1);

        for (int i = 1; i < s.length(); i++) {
            char now = s.charAt(i);

            if (!(order.get(now) == before || before == now)) {
                System.out.println(0);
                return;
            }

            wordsCounter.put(now, wordsCounter.getOrDefault(now, 0) + 1);
            before = now;
        }

        Set<Integer> sizeSet = new HashSet<>();
        for (Integer value : wordsCounter.values()) {
            sizeSet.add(value);
        }

        if (sizeSet.size() != 1) {
            System.out.println(0);
            return;
        }

        System.out.println(1);
    }
}
