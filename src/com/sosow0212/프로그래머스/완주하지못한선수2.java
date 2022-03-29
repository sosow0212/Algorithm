package com.sosow0212.프로그래머스;

import java.util.HashMap;

// 해시로 풀이
public class 완주하지못한선수2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String str : participant) {
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
        }


        for (String str : completion) {
            hashMap.put(str, hashMap.get(str) - 1);
        }

        for(String str : participant) {
            if(hashMap.get(str) == 1) {
                answer = str;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        완주하지못한선수2 sol = new 완주하지못한선수2();

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        System.out.println(sol.solution(participant, completion));

    }
}