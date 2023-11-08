package com.sosow0212.프로그래머스;

import java.util.LinkedHashMap;
import java.util.Map;

public class 성격유형 {

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        Map<Character, Integer> typeMap = new LinkedHashMap<>(Map.of(
                'R', 0,
                'T', 0,
                'C', 0,
                'F', 0,
                'J', 0,
                'M', 0,
                'A', 0,
                'N', 0
        ));

        for (int i = 0; i < survey.length; i++) {
            String types = survey[i];
            int likePoint = choices[i];
            int point = Math.abs(4 - likePoint);

            if (likePoint <= 3) {
                typeMap.put(types.charAt(0), typeMap.getOrDefault(types.charAt(0), 0) + point);
            } else if (likePoint >= 5) {
                typeMap.put(types.charAt(1), typeMap.getOrDefault(types.charAt(1), 0) + point);
            } else {
                // 동점
                typeMap.put(types.charAt(0), typeMap.getOrDefault(types.charAt(0), 0));
                typeMap.put(types.charAt(1), typeMap.getOrDefault(types.charAt(1), 0));
            }
        }

        // a b c d e f g h i j k l m n o p q r s t u v w x y z
        Integer rion = typeMap.get('R');
        Integer tube = typeMap.get('T');
        if (rion >= tube) {
            answer.append('R');
        } else {
            answer.append('T');
        }

        Integer con = typeMap.get('C');
        Integer frode = typeMap.get('F');
        if (con >= frode) {
            answer.append('C');
        } else {
            answer.append('F');
        }

        Integer jay = typeMap.get('J');
        Integer muzi = typeMap.get('M');
        if (jay >= muzi) {
            answer.append('J');
        } else {
            answer.append('M');
        }

        Integer ap = typeMap.get('A');
        Integer neo = typeMap.get('N');
        if (ap >= neo) {
            answer.append('A');
        } else {
            answer.append('N');
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String[] survey = {"RT", "RT", "RT"};
        int[] choices = {7, 5, 2};

        // TCMA
        System.out.println(solution(survey, choices));
    }
}
