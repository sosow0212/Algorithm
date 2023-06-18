package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 메뉴리뉴얼 {

    static HashMap<String, Integer> map;
    static HashMap<Integer, String> answer;
    static boolean[] visited;

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        answer = new HashMap<>();

        // 1. 백트래킹
        for (String order : orders) {
            initPermutation(order);
        }

        System.out.println(map);

        // 2. 정답 찾기
        for (int courseCount : course) {
            for (String key : map.keySet()) {
                if (key.length() == courseCount) {
                    Integer sizeOfPickMenus = map.get(key);
                    int beforeSize = answer.getOrDefault(key, "").length();

                    if (sizeOfPickMenus >= beforeSize) {
                        answer.put(courseCount, key);
                    }
                }
            }
        }

        System.out.println(answer);


        return null;
    }

    private void initPermutation(final String key) {
        visited = new boolean[key.length()];
        doPermutation(0, "", key);
    }

    private void doPermutation(final int index, final String combination, final String key) {
        if (index != 0) {
            List<String> collect = Arrays.stream(combination.split("")).sorted().toList();
            map.put(combination, map.getOrDefault(collect.toString(), 0) + 1);
        }

        for (int i = 0; i < key.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                doPermutation(index + 1, combination + key.charAt(i), key);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        메뉴리뉴얼 sol = new 메뉴리뉴얼();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        // ["AC", "ACDE", "BCFG", "CDE"]
        System.out.println(Arrays.toString(sol.solution(orders, course)));

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};

        // "ACD", "AD", "ADE", "CD", "XYZ"
//        System.out.println(Arrays.toString(sol.solution(orders2, course2)));
    }
}
