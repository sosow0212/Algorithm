package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {

    public static List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        int mapIndex = 26;

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            map.put(String.valueOf(ch), i + 1);
        }

        int index = 0;

        while (index < msg.length()) {
            String nowInput = "";

            while (index < msg.length()) {
                if (map.containsKey(nowInput + msg.charAt(index))) {
                    nowInput += msg.charAt(index);
                    index++;
                } else {
                    break;
                }
            }

            answer.add(map.get(nowInput));
            if (index < msg.length()) {
                mapIndex++;
                map.put(nowInput + msg.charAt(index), mapIndex);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        // [11, 1, 27, 15]
        System.out.println(solution("KAKAO"));

        // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
    }
}
