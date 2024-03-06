package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 상호평가 {

    static int n;
    static int m;

    public static String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();

        n = scores.length;
        m = scores[0].length;
        Map<Integer, Integer> maxMap = new HashMap<>();
        Map<Integer, Integer> minMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            maxMap = new HashMap<>();
            minMap = new HashMap<>();

            for (int j = 0; j < m; j++) {
                maxMap.put(scores[i][j], maxMap.getOrDefault(scores[i][j], 0) + 1);
                minMap.put(scores[i][j], minMap.getOrDefault(scores[i][j], 0) + 1);
                max = Math.max(max, scores[i][j]);
                min = Math.min(min, scores[i][j]);
            }

            double sum = 0;
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i == j && (maxMap.get(scores[i][i]) == 1 || minMap.get(scores[i][i]) == 1)) {
                    continue;
                }
                sum += scores[j][i];
                count++;
            }

            double avg = sum / count;
            String result = getScoreFromAverage(avg);
            answer.append(result);
        }

        return answer.toString();
    }

    static String getScoreFromAverage(double avg) {
        if (avg >= 90) {
            return "A";
        }

        if (avg >= 80) {
            return "B";
        }

        if (avg >= 70) {
            return "C";
        }

        if (avg >= 50) {
            return "D";
        }

        return "F";
    }

    public static void main(String[] args) {
        int[][] scores = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};

        // FBABD
        System.out.println(solution(scores));
    }
}
