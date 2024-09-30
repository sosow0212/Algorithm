package com.sosow0212.프로그래머스다시;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 보석쇼핑2 {

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gem = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int gap = Integer.MAX_VALUE;

        while (right != gems.length) {
            if (gem.size() == map.size()) {
                // 보석이 가득찬 경우
                map.put(gems[left], map.get(gems[left]) - 1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }

                left++;
            } else {
                // 보석이 가득차지 않은 경우
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (map.size() == gem.size()) {
                if (right - left < gap) {
                    gap = right - left;
                    answer = new int[]{left + 1, right};
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        보석쇼핑2 sol = new 보석쇼핑2();

        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

        // 3, 7
        System.out.println(Arrays.toString(sol.solution(gems)));
    }
}
