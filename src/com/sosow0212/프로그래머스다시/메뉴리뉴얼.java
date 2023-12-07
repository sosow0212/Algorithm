package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class 메뉴리뉴얼 {

    static Map<String, Integer> menus;

    public static List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        menus = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            char[] orderArr = orders[i].toCharArray();
            Arrays.sort(orderArr);
            orders[i] = String.valueOf(orderArr);
        }

        for (int length : course) {
            for (String order : orders) {
                permutation(length, "", order);
            }

            if (menus.isEmpty()) {
                continue;
            }

            Integer mostFavoriteOrderCount = Collections.max(menus.values());

            if (mostFavoriteOrderCount < 2) {
                continue;
            }

            for (String menu : menus.keySet()) {
                Integer count = menus.get(menu);

                if (Objects.equals(count, mostFavoriteOrderCount)) {
                    answer.add(menu);
                }
            }

            menus.clear();
        }

        Collections.sort(answer);
        return answer;
    }

    static void permutation(int length, String sum, String order) {
        if (length == 0) {
            menus.put(sum, menus.getOrDefault(sum, 0) + 1);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            permutation(length - 1, sum + c, order.substring(i + 1));
        }
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        // ["AC", "ACDE", "BCFG", "CDE"]
        System.out.println(solution(orders, course));

        // wx xy
        System.out.println(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}));
    }
}
