package com.sosow0212.woowa_study.set8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class q9017_2 {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> teamAndGoalCount = new HashMap<>();
        List<Integer> goaledTeam = new ArrayList<>();

        for (int i : arr) {
            int value = teamAndGoalCount.getOrDefault(i, 0) + 1;
            teamAndGoalCount.put(i, value);
            if (value == 6) {
                goaledTeam.add(i);
            }
        }

        Map<Integer, Integer> score = new HashMap<>();
        Map<Integer, Integer> goalCount = new HashMap<>();
        Map<Integer, Integer> lastGoalScore = new HashMap<>();

        int time = 0;
        for (int i : arr) {
            if (!goaledTeam.contains(i)) {
                continue;
            }

            time++;
            score.put(i, score.getOrDefault(i, 0) + time);

            goalCount.put(i, goalCount.getOrDefault(i, 0) + 1);

            if (goalCount.get(i) == 4) {
                lastGoalScore.put(i, time);
            }
        }

        int winnerPoint = Integer.MAX_VALUE;
        for (Integer i : score.keySet()) {
            winnerPoint = Math.min(winnerPoint, score.get(i));
        }

        List<Integer> winnerTeam = new ArrayList<>();
        for (Integer i : score.keySet()) {
            if (score.get(i) == winnerPoint) {
                winnerTeam.add(i);
            }
        }

        if (winnerTeam.size() == 1) {
            System.out.println(winnerTeam.get(0));
        } else {
            int min = Integer.MAX_VALUE;

            for (Integer i : lastGoalScore.keySet()) {
                min = Math.min(lastGoalScore.get(i), min);
            }

            for (Integer i : lastGoalScore.keySet()) {
                if (lastGoalScore.get(i) == min) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
