package com.sosow0212.백준;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class q13414 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < k; i++) {
            String name = sc.next();

            if (map.containsKey(name)) {
                map.remove(name);
                map.put(name, -1);
            } else {
                map.put(name, -1);
            }

        }

        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (String s : map.keySet()) {
            if (index == n) {
                break;
            }

            sb.append(s).append("\n");
            index++;
        }

        System.out.println(sb);
    }
}
