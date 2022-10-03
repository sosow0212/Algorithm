package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 캐시 {
    static public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return (5 * cities.length);
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            if (list.remove(city)) {
                answer += 1;
                list.add(city);
            } else {
                answer += 5;
                if (list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(city);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(cacheSize, cities));
    }
}