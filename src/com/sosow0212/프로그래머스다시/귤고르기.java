package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // 1 4 2 2 3 3 5 5
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> values = new ArrayList<>();
        for (Integer value : map.values()) {
            values.add(value);
        }

        values.sort(Collections.reverseOrder());

        for (Integer value : values) {
            answer++;
            k -= value;

            if (k <= 0) {
                break;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        귤고르기 sol = new 귤고르기();

        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        // 3
        System.out.println(sol.solution(k, tangerine));
    }
}
