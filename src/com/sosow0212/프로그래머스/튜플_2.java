package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 튜플_2 {

    public static Set<Integer> solution(String s) {
        Set<Integer> answer = new LinkedHashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        s = s.replaceAll("\\{", "");
        String[] split = s.substring(0, s.length() - 2)
                .split("\\},");

        List<Integer> temp = new ArrayList<>();
        for (String str : split) {
            str = str.trim();

            for (String number : str.split(",")) {
                temp.add(Integer.parseInt(number));
            }

            map.put(temp.size(), temp);
            temp = new ArrayList<>();
        }

        for (Integer size : map.keySet()) {
            if (size == 0) {
                continue;
            }

            List<Integer> list = map.get(size);
            answer.addAll(list);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(solution(s)); // 2 1 3 4

        String s2 = "{{20,111},{111}}";
        System.out.println(solution(s2)); // 111, 20
    }
}
