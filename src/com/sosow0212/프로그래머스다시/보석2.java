package com.sosow0212.프로그래머스다시;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 보석2 {

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemSet = new LinkedHashSet<>(List.of(gems));
        Map<String, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int gap = Integer.MAX_VALUE;

        while (r != gems.length) {
            if (gemSet.size() > map.size()) {
                map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
                r++;
            } else if (gemSet.size() == map.size()) {
                map.put(gems[l], map.get(gems[l]) - 1);

                if (map.get(gems[l]) == 0) {
                    map.remove(gems[l]);
                }

                l++;
            }

            if (map.size() == gemSet.size()) {
                if (r - l < gap) {
                    gap = r - l;
                    answer = new int[]{l + 1, r};
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

        // 3 7
        System.out.println(Arrays.toString(solution(gems)));
    }
}
