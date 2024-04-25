package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열내맘대로정리하기2 {
    public static String[] solution(String[] strings, int n) {
        String[] answer = {};
        List<String> list = new ArrayList<>();

        for (String string : strings) {
            list.add(string.charAt(n) + string);
        }

        Collections.sort(list);
        answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] str = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(solution(str, n));

    }
}
