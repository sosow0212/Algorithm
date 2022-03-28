package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 완주하지못한선수2 {
    public static String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        // 1 2 3
        // 1 2
        for(int i=0; i< completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        return participant[participant.length-1];

    }

    public static void main(String[] args) {
        String[] participant = {"leo", "eden", "kiki"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }
}