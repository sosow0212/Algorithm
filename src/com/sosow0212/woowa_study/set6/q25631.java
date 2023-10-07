package com.sosow0212.woowa_study.set6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q25631 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int n = sc.nextInt();
        Map<Integer, Integer> doll = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            doll.put(temp, doll.getOrDefault(temp, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : doll.entrySet()) {
            answer = Math.max(answer, entry.getValue());
        }

        System.out.println(answer);
    }
}
