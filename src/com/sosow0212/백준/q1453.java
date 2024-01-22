package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q1453 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (map.containsKey(num)) {
                answer++;
            } else {
                map.put(num, 1);
            }
        }

        System.out.println(answer);
    }
}
