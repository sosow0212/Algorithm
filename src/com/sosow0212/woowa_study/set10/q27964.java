package com.sosow0212.woowa_study.set10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q27964 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, -1);
        }

        int answer = 0;
        if (map.keySet().size() >= 4) {
            for (String s : map.keySet()) {
                if (s.endsWith("Cheese")) {
                    answer++;
                }
            }
        }

        if (answer >= 4) {
            System.out.println("yummy");
            return;
        }

        System.out.println("sad");
    }
}
