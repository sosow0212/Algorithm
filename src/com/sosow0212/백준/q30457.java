package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q30457 {

    public static void main(String[] args) {
        // 1 2 2 2 3 3 4 4 4 7

        // 1 2 3 4 7 4 3 2

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        int answer = 0;
        for (Integer key : keys) {
            Integer value = map.get(key);

            if (value == 1) {
                answer += 1;
                continue;
            } else if (value >= 2) {
                answer += 2;
            }
        }

        System.out.println(answer);
    }
}
