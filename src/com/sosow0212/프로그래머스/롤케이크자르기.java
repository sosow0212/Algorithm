package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class 롤케이크자르기 {

    public static int solution(int[] topping) {
        int answer = 0;

        HashSet<Integer> set = new LinkedHashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : topping) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.get(topping[i]) - 1);
            set.add(topping[i]);

            if(map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }

            if (map.size() == set.size()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(topping1)); // 2


        int[] topping2 = {1, 2, 3, 1, 4};
        System.out.println(solution(topping2)); // 0
    }
}
