package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q1411 {

    static int n;
    static String[] str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        str = new String[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(str[i], str[j])) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean isSimilar(String s1, String s2) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Boolean> valid = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (!map.containsKey(s1.charAt(i)) && !valid.containsKey(s2.charAt(i))) {
                map.put(s1.charAt(i), s2.charAt(i));
                valid.put(s2.charAt(i), true);
            } else {
                if (!map.containsKey(s1.charAt(i)) || map.get(s1.charAt(i)) != s2.charAt(i))
                    return false;
            }
        }

        return true;
    }
}
