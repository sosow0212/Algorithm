package com.sosow0212.프로그래머스다시;

import java.util.LinkedHashMap;
import java.util.Map;

public class 뉴스클러스터링 {

    private static final int DEFAULT_VALUE = 65536;

    static int intersection;
    static int union;

    public static int solution(String str1, String str2) {
        intersection = 0;
        union = 0;

        Map<String, Integer> a = makeMap(str1);
        Map<String, Integer> b = makeMap(str2);

        for (String aKey : a.keySet()) {
            if (b.containsKey(aKey)) {
                intersection += Math.min(a.get(aKey), b.get(aKey));
            }
        }
        union -= intersection; // 중복 포함 전체 - 교집합 = 합집합

        if (union == 0) {
            return DEFAULT_VALUE;
        }

        return (int) (DEFAULT_VALUE * ((double) intersection / union));
    }

    private static Map<String, Integer> makeMap(String str) {
        Map<String, Integer> map = new LinkedHashMap<>();

        str = str.toLowerCase();

        for (int i = 0; i < str.length() - 1; i++) {
            String substring = str.substring(i, i + 2);

            boolean isPass = false;
            for (char c : substring.toCharArray()) {
                if (!Character.isAlphabetic(c)) {
                    isPass = true;
                    break;
                }
            }

            if (isPass) {
                continue;
            }

            map.put(substring, map.getOrDefault(substring, 0) + 1);
            union += 1;
        }

        return map;
    }

    public static void main(String[] args) {
        // 16384
//        System.out.println(solution("FRANCE", "french"));

        // 65536
//        System.out.println(solution("handshake", "shake hands"));

        // 43690
        System.out.println(solution("aa1+aa2", "AAAA12"));
    }
}
