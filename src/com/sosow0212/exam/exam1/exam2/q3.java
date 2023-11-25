package com.sosow0212.exam.exam1.exam2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q3 {

    public List<String> solution(String[] merchantNames) {
        int maxValue = Integer.MIN_VALUE;
        int specialMaxValue = Integer.MIN_VALUE;

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> special = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();

        for (String merchantName : merchantNames) {
            String edit = merchantName.replaceAll(" ", "");
            int length = edit.length();

            if (edit.contains("&") || edit.contains("(") || edit.contains(")") || edit.contains(".") || edit.contains(",") || edit.contains("-")) {
                specialMaxValue = Math.max(specialMaxValue, length);
                special.put(merchantName, length);
            } else {
                maxValue = Math.max(maxValue, length);
                map.put(merchantName, length);
            }
        }

        for (String key : special.keySet()) {
            if (special.get(key) == specialMaxValue) {
                answerMap.put(key, map.get(key));
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == maxValue) {
                answerMap.put(key, map.get(key));
            }
        }

        return new ArrayList<>(answerMap.keySet());
    }

    public static void main(String[] args) {
        q3 sol = new q3();
        String[] merchantNames = {"토스커피사일로&베이커리", "토스커피사일로 베이커리", "토스커피사일로 베이커", "토스커피사일로 베이", "토스커피사일", "비바리퍼블리카 식당", "비바리퍼블리카식", "비바리퍼블리"};

        // 토스커피사일로&베이커리, 비바리퍼블리카 식당
        sol.solution(merchantNames);
    }
}
