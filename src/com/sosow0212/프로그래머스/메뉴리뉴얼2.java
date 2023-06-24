package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 메뉴리뉴얼2 {

    List<String> answer;
    Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        answer = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = String.valueOf(ch);
        }

        for (int c : course) {
            for (String order : orders) {
                combination("", order, c);
            }

            if (!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);

                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answer.add(key);
                        }
                    }
                }

                map.clear();
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public void combination(String sum, String order, int index) {
        if (index == 0) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            combination(sum + order.charAt(i), order.substring(i + 1), index - 1);
        }
    }


    public static void main(String[] args) {
        메뉴리뉴얼2 sol = new 메뉴리뉴얼2();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        // ["AC", "ACDE", "BCFG", "CDE"]
        System.out.println(Arrays.toString(sol.solution(orders, course)));

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};

//         "ACD", "AD", "ADE", "CD", "XYZ"
        System.out.println(Arrays.toString(sol.solution(orders2, course2)));
    }
}
