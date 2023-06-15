package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], (i + 1));
        }

        for (String calling : callings) {
            String changeTemp = "";
            changeTemp = players[map.get(calling) - 2];

            players[map.get(calling) - 2] = players[map.get(calling) - 1];
            players[map.get(calling) - 1] = changeTemp;

            map.put(calling, map.get(calling) - 1);
            map.put(changeTemp, map.get(changeTemp) + 1);

        }

        return players;
    }

    public static void main(String[] args) {
        달리기경주 sol = new 달리기경주();

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        // ["mumu", "kai", "mine", "soe", "poe"]
        System.out.println(Arrays.toString(sol.solution(players, callings)));
    }
}
