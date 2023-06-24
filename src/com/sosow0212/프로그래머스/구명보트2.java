package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 구명보트2 {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        // 100,500,500,900,950 limit 1000 > 3

        int min = 0;
        int max = people.length - 1;

        while (max >= min) {
            if (people[min] + people[max] <= limit) {
                answer++;
                max--;
                min++;
            } else {
                max--;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        구명보트2 sol = new 구명보트2();
        int[] people = {40, 50, 150, 160};
        int limit = 200;

        int[] people2 = {100, 500, 500, 900, 950};
        int limit2 = 2000;

        // 2
        System.out.println(sol.solution(people, limit));

        // 3
        System.out.println(sol.solution(people2, limit2));
    }
}
