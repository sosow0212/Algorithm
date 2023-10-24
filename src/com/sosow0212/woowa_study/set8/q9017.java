package com.sosow0212.woowa_study.set8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class q9017 {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            solve();
        }
    }

    static void solve() {
        Map<Integer, Integer> teamAndGoal = new HashMap<>();
        Map<Integer, Integer> teamAndTime = new HashMap<>();
        Map<Integer, Integer> teamAndLastIn = new HashMap<>();
        Map<Integer, Integer> teamGoal = new HashMap<>();

        int n = sc.nextInt();
        int[] scoreBoard = new int[n];

        for (int i = 0; i < scoreBoard.length; i++) {
            scoreBoard[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int team = scoreBoard[i];

            teamAndGoal.put(team, teamAndGoal.getOrDefault(team, 0) + 1);
        }

        List<Integer> notGoalTeam = teamAndGoal.keySet().stream()
                .filter(it -> teamAndGoal.get(it) < 6)
                .collect(Collectors.toList());

        int time = 0;
        for (int i = 0; i < n; i++) {
            int team = scoreBoard[i];
            if (notGoalTeam.contains(team)) {
                continue;
            }

            time++;
            teamGoal.put(team, teamGoal.getOrDefault(team, 0) + 1);
            if (teamGoal.get(team) == 4) {
                teamAndLastIn.put(team, time);
            }


            if (teamGoal.get(team) <= 4) {
                teamAndTime.put(team, teamAndTime.getOrDefault(team, 0) + time);
            }
        }

        int winnerScore = Integer.MAX_VALUE;

        List<Integer> winnerTeam = new ArrayList<>();

        for (Integer key : teamAndTime.keySet()) {
            if (teamAndTime.get(key) < winnerScore) {
                winnerScore = teamAndTime.get(key);
            }
        }

        for (Integer key : teamAndTime.keySet()) {
            if (teamAndTime.get(key) == winnerScore) {
                winnerTeam.add(key);
            }
        }

        if (winnerTeam.size() == 1) {
            return;
        }

        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (Integer team : winnerTeam) {
            if (teamAndLastIn.get(team) < min) {
                min = teamAndLastIn.get(team);
                answer = team;
            }
        }

        System.out.println(answer);
    }
}
