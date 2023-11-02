package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q2979 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        Map<Integer, Integer> timeAndTruck = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int j = start; j < end; j++) {
                timeAndTruck.put(j, timeAndTruck.getOrDefault(j, 0) + 1);
            }
        }

        int answer = 0;

        for (Integer i : timeAndTruck.keySet()) {
            if (timeAndTruck.get(i) == 1) {
                answer += a;
            }

            if (timeAndTruck.get(i) == 2) {
                answer += (2 * b);
            }

            if (timeAndTruck.get(i) == 3) {
                answer += (3 * c);
            }
        }

        System.out.println(answer);
    }
}
