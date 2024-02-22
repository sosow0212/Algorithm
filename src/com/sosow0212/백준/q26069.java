package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q26069 {

    static final String ME = "ChongChong";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int n = sc.nextInt();

        Map<String, Boolean> map = new HashMap<>();
        map.put(ME, true);

        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();

            if (map.containsKey(a) || map.containsKey(b)) {
                map.put(a, true);
                map.put(b, true);
            }
        }

        System.out.println(map.size());
    }
}
