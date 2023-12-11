package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 단체사진찍기 {

    static final String[] CHARACTERS = {"A", "C", "F", "J", "M", "N", "R", "T"};

    static Map<Integer, String> given;
    static boolean[] visited;
    static int answer;

    public static int solution(int n, String[] data) {
        answer = 0;

        given = new HashMap<>();
        visited = new boolean[CHARACTERS.length];

        for (int i = 0; i < n; i++) {
            given.put(i + 1, data[i]);
        }

        permutation(0, "");

        return answer;
    }

    static void permutation(int index, String sum) {
        if (index == CHARACTERS.length) {
            for (Integer caseNumber : given.keySet()) {
                String c = given.get(caseNumber);

                String[] split = c.split("");
                String a = split[0];
                String b = split[2];
                String op = split[3];

                int indexA = sum.indexOf(a);
                int indexB = sum.indexOf(b);

                int gap = Integer.parseInt(split[4]);
                int abs = Math.abs(indexA - indexB) - 1;

                if (op.equals("=")) {
                    if (abs != gap) {
                        return;
                    }
                } else if (op.equals(">")) {
                    if (abs <= gap) {
                        return;
                    }
                } else if (op.equals("<")) {
                    if (abs >= gap) {
                        return;
                    }
                }
            }

            answer++;
            return;
        }

        for (int i = 0; i < CHARACTERS.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(index + 1, sum + CHARACTERS[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        // 3648
        System.out.println(solution(n, data));
    }
}
