package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.Map;

class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 1. Map 초기화
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        // 2. discount 품목을 10개씩 선정하면서 Map의 밸류와 값이 같다면 anwer += 1 처리
        for (int i = 0; i < discount.length - 9; i++) {
            // 2-1 discountMap 을 채운다.
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = i; j < 10 + i; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            // 2-2 밸류 값이 같다면, depth(일치하는 것의 수) += 1을 해준다.
            int depth = 0;
            for (String wantKey : map.keySet()) {
                if (map.get(wantKey) == discountMap.get(wantKey)) {
                    depth++;
                }
            }

            // 2-3 일치하는 것의 수가, 품목의 수와 같다면 answer += 1을 해준다.
            if (depth == number.length) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        할인행사 sol = new 할인행사();

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana"};

        String[] want2 = {"apple"};
        int[] number2 = {10};
        String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                "banana"};

        System.out.println(sol.solution(want, number, discount)); // 3
        System.out.println(sol.solution(want2, number2, discount2)); // 0
    }
}
