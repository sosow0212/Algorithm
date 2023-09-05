package com.sosow0212.프로그래머스다시;

import java.util.LinkedList;
import java.util.List;

public class 캐시 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> list = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();

            if (list.size() < cacheSize) {
                if (list.contains(city)) {
                    list.remove(city);
                    list.add(city);
                    answer++;
                } else {
                    list.add(city);
                    answer += 5;
                }
            } else {
                if (list.contains(city)) {
                    list.remove(city);
                    list.add(city);
                    answer++;
                } else {
                    list.remove(0);
                    list.add(city);
                    answer += 5;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        캐시 sol = new 캐시();

        int cacheSize = 3;

        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
//        System.out.println(sol.solution(cacheSize, cities1)); // 50


        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };
//        System.out.println(sol.solution(cacheSize, cities2)); // 21

        String[] cities3 = {"Jeju", "Pangyo", "NewYork", "newyork" };
        int cacheSize3 = 2;
        System.out.println(sol.solution(cacheSize3, cities3)); // 16
    }
}
