package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 다트게임 {

    private static final Map<Character, Integer> BONUS = Map.of(
            'S', 1,
            'D', 2,
            'T', 3
    );

    private static final List<Character> OPTION = List.of('*', '#');

    static public int solution(String dartResult) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                if (c == '0') {
                    // 맨 처음 첫번째 숫자가 0인 경우
                    if (i == 0) {
                        list.add(c - '0');
                        continue;
                    }

                    // 이후에 정말 0인 경우
                    if (i >= 2 && !Character.isDigit(dartResult.charAt(i - 1))) {
                        list.add(c - '0');
                        continue;
                    }

                    // 10인 경우
                    if (i >= 1 && Character.isDigit(dartResult.charAt(i - 1))) {
                        list.remove(list.size() - 1);
                        list.add(10);
                    }

                } else {
                    int score = c - '0';
                    list.add(score);
                }
            } else if (BONUS.containsKey(c)) {
                Integer score = list.remove(list.size() - 1);
                list.add((int) Math.pow(score, BONUS.get(c)));
            } else if (OPTION.contains(c)) {
                if (c == '*') {
                    int size = list.size();
                    if (size == 1) {
                        Integer score = list.remove(list.size() - 1);
                        list.add(score * 2);
                    } else {
                        Integer scoreNow = list.remove(list.size() - 1);
                        Integer scoreBefore = list.remove(list.size() - 1);

                        list.add(scoreBefore * 2);
                        list.add(scoreNow * 2);
                    }
                } else {
                    Integer score = list.remove(list.size() - 1);
                    list.add(score * -1);
                }
            }
        }
        for (Integer i : list) {
            answer += i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T")); // 37
        System.out.println(solution("1D2S#10S")); // 9
        System.out.println(solution("1D2S0T")); // 3
        System.out.println(solution("1S*2T*3S")); // 23
        System.out.println(solution("1D#2S*3S")); // 5
        System.out.println(solution("1T2D3D#")); // -4
    }
}
