package com.sosow0212.toss.exam1.exam2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q1 {

    public static int solution(String s, int n) {
        int answer = -1;

        // 1234 -> 4 -> 2
        for (int i = 0; i <= s.length() - n; i++) {
            String substring = s.substring(i, i + n);
            List<Integer> list = new ArrayList<>();

            for (char c : substring.toCharArray()) {
                list.add(c - '0');
            }

            Collections.sort(list);

            boolean notFound = false;
            for (int j = 1; j <= n; j++) {
                if (!list.contains(j)) {
                    notFound = true;
                    break;
                }
            }

            if (notFound) {
                continue;
            }

            answer = Math.max(answer, Integer.parseInt(substring));
        }


        return answer;
    }

    public static void main(String[] args) {
        // 21
        System.out.println(solution("1451232125", 2));
    }
}
