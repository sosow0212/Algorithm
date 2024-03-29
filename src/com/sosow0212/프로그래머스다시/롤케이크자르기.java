package com.sosow0212.프로그래머스다시;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤케이크자르기 {

    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for (int t : topping) {
            set.add(t);
            map.put(t, map.get(t) - 1);

            if (map.get(t) == 0) {
                map.remove(t);
            }

            if (set.size() == map.size()) {
                answer++;
            }
        }

        return answer;
    }
}
