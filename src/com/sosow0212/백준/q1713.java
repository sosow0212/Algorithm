package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class q1713 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> map = new LinkedHashMap<>();

        int albumCount = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int student = sc.nextInt();

            if (map.size() == albumCount && !map.containsKey(student)) {
                ArrayList<Integer> keys = new ArrayList<>(map.keySet());
                Collections.sort(keys, (o1, o2) -> map.get(o1).compareTo(map.get(o2)));
                map.remove(keys.get(0));
            }

            map.put(student, map.getOrDefault(student, 0) + 1);
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (Integer key : keys) {
            sb.append(key + " ");
        }

        System.out.println(sb);
    }
}
