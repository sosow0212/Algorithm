package com.sosow0212.프로그래머스다시;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class 할인행사_2 {

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            String product = want[i];
            int quantity = number[i];

            map.put(product, quantity);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> buy = new LinkedHashMap<>();
            boolean canBuy = true;

            for (int j = i; j < i + 10; j++) {
                buy.put(discount[j], buy.getOrDefault(discount[j], 0) + 1);
            }

            for (String key : map.keySet()) {
                if (!buy.containsKey(key) || buy.get(key) < map.get(key)) {
                    canBuy = false;
                    break;
                }
            }

            if (canBuy) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] numbers = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        // 3
        System.out.println(solution(want, numbers, discount));
    }
}
