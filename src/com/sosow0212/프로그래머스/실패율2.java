package com.sosow0212.프로그래머스;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

    public class 실패율2 {
        static public List<Integer> solution(int n, int[] stages) {
            HashMap<Integer, Integer> stageFailureCountMap = new HashMap<>();
            HashMap<Integer, Double> stageFailureMap = new HashMap<>();

            // 0. 초기화
            for (int i = 1; i <= n; i++) {
                stageFailureCountMap.put(i, 0);
                stageFailureMap.put(i, 0.0);
            }

            // 1. 실패율 구하기
            for (int stage : stages) {
                if (stage == n + 1) {
                    stageFailureCountMap.put(n, stageFailureCountMap.getOrDefault(n, 0) + 0);
                    continue;
                }
                stageFailureCountMap.put(stage, stageFailureCountMap.getOrDefault(stage, 0) + 1);
            }

            // 2. 실패율 계산하기
            int total = stages.length;
            for (int key : stageFailureCountMap.keySet()) {
                if (total == 0) {
                    stageFailureMap.put(key, 0.0);
                    continue;
                }
                stageFailureMap.put(key, (double) stageFailureCountMap.get(key) / total);
                total -= stageFailureCountMap.get(key);
            }

            // 3. 실패율 내림차순 정렬하기
            List<Integer> answer = stageFailureMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            return answer;
        }


    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(solution(n, stages)); // 3,4,2,1,5
    }
}
