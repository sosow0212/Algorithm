package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.Collections;

public class 과제진행 {

    public String[] solution(String[][] plans) {
        String[] answer = {};

//        Collections.sort((o1, o2) -> o1[1] - o2[1]);

        return answer;
    }

    public static void main(String[] args) {
        과제진행 sol = new 과제진행();

        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        // ["science", "history", "computer", "music"]
        System.out.println(Arrays.toString(sol.solution(plans)));
    }
}
