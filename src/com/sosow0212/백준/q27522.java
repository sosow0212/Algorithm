package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class q27522 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Character> map = new LinkedHashMap<>();
        Map<Integer, Integer> scores = Map.of(
                1, 10,
                2, 8,
                3, 6,
                4, 5,
                5, 4,
                6, 3,
                7, 2,
                8, 1
        );

        int red = 0;
        int blue = 0;

        for (int i = 0; i < 8; i++) {
            String[] split = sc.nextLine().split(" ");
            map.put(split[0], split[1].charAt(0));
        }

        ArrayList<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            Integer score = scores.get(i + 1);
            Character team = map.get(keys.get(i));

            if (team == 'B') {
                blue += score;
            } else {
                red += score;
            }
        }

        if (blue > red) {
            System.out.println("Blue");
        } else {
            System.out.println("Red");
        }
    }
}
