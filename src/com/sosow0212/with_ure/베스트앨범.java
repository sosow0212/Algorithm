package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class 베스트앨범 {

    public static List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        List<String> orders = new ArrayList<>();

        Map<String, Integer> genreOrder = new HashMap<>();
        Map<String, Map<Integer, Integer>> genreAndPlayCountAndIndex = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreOrder.put(genres[i], genreOrder.getOrDefault(genres[i], 0) + plays[i]);

            if (!genreAndPlayCountAndIndex.containsKey(genres[i])) {
                genreAndPlayCountAndIndex.put(genres[i], new HashMap<>());
            }

            genreAndPlayCountAndIndex.get(genres[i]).put(plays[i], i);
        }
        System.out.println("111 " + genreAndPlayCountAndIndex);

        while (!genreOrder.isEmpty()) {
            int max = Integer.MIN_VALUE;
            String key = null;

            for (String s : genreOrder.keySet()) {
                if (genreOrder.get(s) > max) {
                    key = s;
                    max = genreOrder.get(s);
                }
            }

            genreOrder.remove(key);
            orders.add(key);
        }
        System.out.println("222 " + orders);

        // Map<String, Map<Count, Order>> genreAndPlayCount
        for (String order : orders) {
            Map<Integer, Integer> countAndOrderMap = genreAndPlayCountAndIndex.get(order);

            List<Integer> listUp = countAndOrderMap.keySet().stream()
                    .map(countAndOrderMap::get)
                    .limit(2)
                    .collect(Collectors.toList());

            answer.addAll(listUp);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 600};

        // 3014
        System.out.println(solution(genres, plays));
    }
}
