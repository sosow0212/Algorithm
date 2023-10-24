package com.sosow0212.woowa_study.set9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class q20006 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        LinkedHashMap<String, Integer> players = new LinkedHashMap<>();
        List<LinkedHashMap<String, Integer>> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            String name = sc.next();
            players.put(name, score);
        }

        List<String> keySet = new ArrayList<>(players.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int scoreComparison = players.get(o1).compareTo(players.get(o2));

                if (scoreComparison == 0) {
                    return o1.compareTo(o2);
                }

                return scoreComparison;
            }
        });

        int index = 0;
        int roomIndex = 0;
        rooms.add(new LinkedHashMap<>());

        int startPoint = players.get(keySet.get(0));

        for (String key : keySet) {
            if (index == m) {
                index = 0;
                roomIndex++;
                rooms.add(new LinkedHashMap<>());
                startPoint = players.get(key);
                rooms.get(roomIndex).put(key, players.get(key));
                index++;
                continue;
            }

            if (index < m && players.get(key) <= startPoint + 10) {
                rooms.get(roomIndex).put(key, players.get(key));
                index++;
            } else {
                index = 0;
                rooms.get(roomIndex).put(key, players.get(key));
                index++;
            }
        }

        for (LinkedHashMap<String, Integer> roomMap : rooms) {
            List<String> roomKeys = new ArrayList<>(roomMap.keySet());
            Collections.sort(roomKeys);

            int size = roomMap.size();

            if (size == m) {
                System.out.println("Started!");
                for (String key : roomKeys) {
                    System.out.println(roomMap.get(key) + " " + key);
                }
                continue;
            }

            System.out.println("Waiting!");
            for (String key : roomKeys) {
                System.out.println(roomMap.get(key) + " " + key);
            }
        }
    }
}
