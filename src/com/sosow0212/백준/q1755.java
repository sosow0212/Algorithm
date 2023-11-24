package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q1755 {

    static Map<String, String> toStringFromNumber = new HashMap<>();

    public static void main(String[] args) {
        toStringFromNumber.put("0", "zero");
        toStringFromNumber.putAll(Map.of(
                "1", "one",
                "2", "two",
                "3", "three",
                "4", "four",
                "5", "five",
                "6", "six",
                "7", "seven",
                "8", "eight",
                "9", "nine",
                "10", "ten"
        ));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, Integer> numbers = new HashMap<>();

        for (int i = n; i <= m; i++) {
            String numberToString = String.valueOf(i);

            StringBuilder sb = new StringBuilder();
            for (String s : numberToString.split("")) {
                sb.append(toStringFromNumber.get(s));
            }

            numbers.put(sb.toString(), i);
        }

        ArrayList<String> keys = new ArrayList<>(numbers.keySet());
        Collections.sort(keys);

        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            if (index == 10) {
                sb.append("\n");
                index = 0;
            }

            sb.append(numbers.get(key) + " ");
            index++;
        }

        System.out.println(sb.toString());
    }
}
