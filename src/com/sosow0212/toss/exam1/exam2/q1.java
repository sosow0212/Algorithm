package com.sosow0212.toss.exam1.exam2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class q1 {

    public int solution(String s, int N) {
        List<String> subStrings = new LinkedList<>();

        for (int i = 0; i <= s.length() - N; i++) {
            subStrings.add(s.substring(i, i + N));
        }

        subStrings.sort(Comparator.reverseOrder());

        for (int i = 0; i < subStrings.size(); i++) {
            String subString = subStrings.get(i);

            for (int j = 1; j <= N; j++) {
                if (!subString.contains(String.valueOf(j))) {
                    break;
                }

                if (j == N) {
                    return Integer.parseInt(subString);
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        q1 sol = new q1();
    }
}
