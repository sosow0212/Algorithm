package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 보석쇼핑 {

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gem = new LinkedHashSet<>(List.of(gems));

        int l = 0;
        int r = 0;
        int gap = Integer.MAX_VALUE;

        Map<String, Integer> map = new HashMap<>();

        while (true) {
            if (gem.size() == map.size()) {
                map.put(gems[l], map.get(gems[l]) - 1);

                if (map.get(gems[l]) == 0) {
                    map.remove(gems[l]);
                }

                l++;
            } else if (r == gems.length) {
                break;
            } else if (gem.size() > map.size()) {
                // 없는 경우
                map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
                r++;
            }

            if (map.size() == gem.size()) {
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
//        System.out.println(Arrays.toString(solution(gems)));

        String[] g2 = {"A", "B", "B", "B", "C", "D", "D", "D", "D", "D", "D", "D", "B", "C", "A"};
        // 12 15
        System.out.println(Arrays.toString(solution(g2)));
    }
}
