package com.sosow0212.프로그래머스;

import java.util.HashMap;

class 성격유형검사하기 {
    private static final String[] INDICATORS = {"RT", "CF", "JM", "AN"};

    public String solution(String[] survey, int[] choices) {
        int[] cnt = new int['Z' - 'A' + 1];
        for (int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            int score = choices[i] - 4;
            if (score == 0) continue;
            if (score < 0) cnt[a - 'A'] -= score;
            else cnt[b - 'A'] += score;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < INDICATORS.length; i++) {
            char a = INDICATORS[i].charAt(0);
            char b = INDICATORS[i].charAt(1);
            int cntA = cnt[a - 'A'];
            int cntB = cnt[b - 'A'];
            if (cntA == cntB) sb.append(a);
            else sb.append(cntA > cntB ? a : b);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        성격유형검사하기 sol = new 성격유형검사하기();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        String[] survey2 = {"TR", "RT", "TR"};
        int[] choices2 = {7, 1, 3};

        System.out.println(sol.solution(survey, choices));  //"TCMA"

        System.out.println(sol.solution(survey2, choices2)); // "RCJA"
    }
}