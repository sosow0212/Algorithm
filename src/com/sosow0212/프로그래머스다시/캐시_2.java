package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.List;

public class 캐시_2 {

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> cache = new ArrayList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toUpperCase();

            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += 1;
            } else {
                if (cache.size() < cacheSize) {
                    cache.add(city);
                } else {
                    cache.remove(0);
                    cache.add(city);
                }

                answer += 5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int cacheSize = 2;
        // 60
//        System.out.println(solution(cacheSize, cities));


        String[] cities2 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        // 16
//        System.out.println(solution(2, cities2));

        // 25
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//        System.out.println(solution(0, cities3));

        // 11
        String[] cities4 = {"A", "B", "A"};
        System.out.println(solution(3, cities4));
    }
}
