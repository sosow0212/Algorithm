package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 가큰수 {

    static int n;
    static boolean[] visited;
    static String[] str;
    static Set<Integer> combination;

    public static String solution(int[] numbers) {
        String answer = "";

        n = numbers.length;
        combination = new HashSet<>();
        visited = new boolean[n];

        str = new String[n];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        permutation(0, "");

        System.out.println(combination);

        List<Integer> candidate = new ArrayList<>(combination);
        Collections.sort(candidate);
        return String.valueOf(candidate.get(candidate.size() - 1));
    }

    static void permutation(int index, String sum) {
        if (index == n) {
            combination.add(Integer.parseInt(sum));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(index + 1, sum + str[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
    }
}
