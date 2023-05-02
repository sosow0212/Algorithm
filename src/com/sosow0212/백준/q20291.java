package com.sosow0212.백준;

import java.util.*;

public class q20291 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            List<String> file = List.of(str.split("\\."));

            map.put(file.get(1), map.getOrDefault(file.get(1), 0) + 1);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
