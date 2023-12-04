package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.List;

public class 캐시_3 {

    static final int HIT = 1;
    static final int MISS = 5;

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();

        if (cacheSize == 0) {
            // 캐시 사이즈가 없는 경우 예외
            return cities.length * MISS;
        }

        for (String city : cities) {
            // 대소문자 통일
            city = city.toLowerCase();

            if (cache.size() < cacheSize) {
                // 캐시 사이즈보다 작은 경우

                if (cache.contains(city)) {
                    // 캐시 사이즈보다 작지만, 캐시에 속한 경우
                    answer += HIT;
                } else {
                    // 캐시 사이즈보다 작지만, 캐시에 없는 경우
                    answer += MISS;
                }

                cache.add(city);
                continue;
            }

            // 캐시 사이즈보다 큰 경우
            if (cache.contains(city)) {
                // 캐시 사이즈보다 크면서 캐시 안에 존재하는 경우
                cache.remove(city);
                cache.add(city);
                answer += HIT;
            } else {
                // 캐시 사이즈보다 크지만, 캐시 안에 도시가 존재하지 않는 경우
                cache.remove(0);
                cache.add(city);
                answer += MISS;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int cacheSize = 2;
        System.out.println(solution(cacheSize, cities)); // 60

        int cs2 = 2;
        String[] ci2 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution(cs2, ci2)); // 16
    }
}
