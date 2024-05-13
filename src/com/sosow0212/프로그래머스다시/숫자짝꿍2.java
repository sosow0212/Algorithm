package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 숫자짝꿍2 {

    public static String solution(String X, String Y) {
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
            int c = X.charAt(i) - '0';
            xMap.put(c, xMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < Y.length(); i++) {
            int c = Y.charAt(i) - '0';
            yMap.put(c, yMap.getOrDefault(c, 0) + 1);
        }

        for (Integer key : xMap.keySet()) {
            if (yMap.containsKey(key)) {
                int size = Math.min(xMap.get(key), yMap.get(key));
                map.put(key, size);
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> o2 - o1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            int value = map.get(key);
            sb.append(("" + key).repeat(value));
        }

        if (sb.isEmpty()) {
            return "-1";
        }

        if (sb.toString().startsWith("0")) {
            return "0";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        // -1
        System.out.println(solution("100", "2345"));
//
//        // 100
        System.out.println(solution("100", "100"));

        // 321
        System.out.println(solution("12321", "42531"));
    }
}
