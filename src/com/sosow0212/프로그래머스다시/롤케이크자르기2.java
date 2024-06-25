package com.sosow0212.프로그래머스다시;

import java.util.HashMap;

public class 롤케이크자르기2 {

    public static int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> half = new HashMap<>();

        for (int i : topping) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : topping) {
            half.put(i, half.getOrDefault(i, 0) + 1);
            map.put(i, map.getOrDefault(i, 0) - 1);

            if (map.get(i) == 0) {
                map.remove(i);
            }

            if (map.size() == half.size()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};

        // 2
        System.out.println(solution(topping));
    }
}
