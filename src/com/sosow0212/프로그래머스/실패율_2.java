package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class 실패율_2 {

    public static int[] solution(int n, int[] stages) {
        int[] answer = {};
        Map<Integer, Integer> peopleInStages = new LinkedHashMap<>();
        Map<Integer, Float> failureInStage = new LinkedHashMap<>();
        int people = stages.length;

        for (int i = 1; i <= n; i++) {
            peopleInStages.put(i, 0);
        }

        for (int stage : stages) {
            if (stage == n + 1) {
                continue;
            }
            peopleInStages.put(stage, peopleInStages.getOrDefault(stage, 0) + 1);
        }

        for (Integer stage : peopleInStages.keySet()) {
            Integer failPeoples = peopleInStages.get(stage);

            if (failPeoples == 0) {
                failureInStage.put(stage, 0F);
                continue;
            }

            failureInStage.put(stage, (float) failPeoples / people);
            people -= failPeoples;
        }

        ArrayList<Map.Entry<Integer, Float>> entries = new ArrayList<>(failureInStage.entrySet());
        entries.sort(
                Map.Entry
                        .<Integer, Float>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey())
        );

        answer = new int[entries.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = entries.get(i).getKey();
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        // 1 2 2 2 3 3 4 6

        // 3 4 2 1 5
        System.out.println(solution(n, stages));
    }
}
