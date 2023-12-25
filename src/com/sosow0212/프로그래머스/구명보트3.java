package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 구명보트3 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int index = 0;

        for(int i= people.length - 1; i>= index; i--) {
            if(people[i] + people[index] <= limit) {
                index ++;
                answer ++;
            } else {
                answer ++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        구명보트3 sol = new 구명보트3();
        System.out.println(sol.solution(people, limit));
    }
}
